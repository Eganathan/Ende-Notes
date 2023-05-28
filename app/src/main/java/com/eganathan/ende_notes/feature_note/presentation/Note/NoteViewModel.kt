package com.eganathan.ende_notes.feature_note.presentation.Note

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eganathan.ende_notes.feature_note.domain.model.InvalidNoteException
import com.eganathan.ende_notes.feature_note.domain.model.Note
import com.eganathan.ende_notes.feature_note.domain.use_cases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    //here we are not grouping the state into a data class because it will recompose the entire data class on every change in text field etc

    private val _noteTitle = mutableStateOf(TextFieldValue())
    val noteTitle: State<TextFieldValue> = _noteTitle

    private val _noteContent = mutableStateOf(TextFieldValue())
    val noteContent: State<TextFieldValue> = _noteContent

    private val _noteColor = mutableStateOf(Note.noteColors.random().toArgb())
    val noteColor: State<Int> = _noteColor

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        savedStateHandle.get<Int>("noteId")?.let { noteId ->
            //print here
            Log.e("Test", "NoteId: $noteId")
            if (noteId >= 0) {
                viewModelScope.launch {
                    noteUseCases.getNoteUseCase(noteId)?.also { note ->
                        configureValues(note)
                    }
                }
            }
        }
    }


    fun onEvent(event: NoteEvent) {
        when (event) {
            is NoteEvent.ChangeColor -> {
                _noteColor.value = event.color
            }

            is NoteEvent.EditedContent -> {
                _noteContent.value = _noteContent.value.copy(text = event.value)
            }

            is NoteEvent.EditedTitle -> {
                _noteTitle.value = _noteTitle.value.copy(text = event.value)
            }

            NoteEvent.SaveNote -> {
                viewModelScope.launch {
                    try {
                        noteUseCases.addNoteUseCase(
                            Note(
                                title = noteTitle.value.text,
                                content = noteContent.value.text,
                                color = noteColor.value,
                                timeStamp = System.currentTimeMillis(),
                            )
                        )
                        _eventFlow.emit(UiEvent.SaveNote)
                    } catch (e: InvalidNoteException) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(
                                e.localizedMessage ?: "Unable to Save Note!"
                            )
                        )
                    }
                }
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackbar(val message: String) : UiEvent()
        object SaveNote : UiEvent()
    }

    private fun configureValues(note: Note) {
        _noteTitle.value = _noteTitle.value.copy(text = note.title)
        _noteContent.value = _noteContent.value.copy(note.content)
        _noteColor.value = note.color
    }


}