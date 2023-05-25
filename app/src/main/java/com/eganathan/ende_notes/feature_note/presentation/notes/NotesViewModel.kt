package com.eganathan.ende_notes.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eganathan.ende_notes.feature_note.domain.model.Note
import com.eganathan.ende_notes.feature_note.domain.use_cases.NoteUseCases
import com.eganathan.ende_notes.feature_note.domain.util.NoteOrder
import com.eganathan.ende_notes.feature_note.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val useCases: NoteUseCases) : ViewModel() {

    // [1] -> Create one wrapper class that holds all the states in one place
    // [2]-> Create a sealed classes that contains all the events expected from notes screen so when the composabled pass the event object the VM can handel it in a expected manner.

    private val _state = mutableStateOf(NotesStates())
    val state: State<NotesStates> = _state

    private var recentlyDeleteNote: Note? = null
    private var getNotesJob: Job? = null


    init {
        getNotes(noteOrder = NoteOrder.Date(OrderType.Ascending))
    }


    fun onEvent(event: NoteEvent) {
        when (event) {
            is NoteEvent.OrderEvent -> {
                if (state.value.noteOrder::class == event.noteOrder::class && state.value.noteOrder.orderType == event.noteOrder.orderType) {
                    return
                } else {
                    getNotes(event.noteOrder)
                }
            }

            is NoteEvent.DeleteEvent -> {
                viewModelScope.launch {
                    recentlyDeleteNote = event.note
                    useCases.deleteNoteUseCase(event.note)
                }
            }

            is NoteEvent.RestoreNote -> {
                viewModelScope.launch {
                    useCases.addNoteUseCase(recentlyDeleteNote ?: return@launch)
                    recentlyDeleteNote = null
                }
            }

            is NoteEvent.ToggleOrderSection -> {
                _state.value =
                    state.value.copy(isOrderSelectionVisible = state.value.isOrderSelectionVisible)
            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = useCases.getNotesUseCase(noteOrder).onEach {
            _state.value = _state.value.copy(
                notes = it, noteOrder = noteOrder
            )
        }.launchIn(viewModelScope)
    }
}