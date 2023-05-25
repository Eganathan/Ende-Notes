package com.eganathan.ende_notes.feature_note.presentation.notes

import com.eganathan.ende_notes.feature_note.domain.model.Note
import com.eganathan.ende_notes.feature_note.domain.util.NoteOrder

//Register all the expected events here so it can be easily handled within the View model and
// the relevant composable can just pass the noteEvent to the view model and it knows what to do
//
sealed class NoteEvent {
    data class OrderEvent(val noteOrder: NoteOrder) : NoteEvent()
    data class DeleteEvent(val note: Note) : NoteEvent()
    object RestoreNote : NoteEvent()
    object ToggleOrderSection : NoteEvent()

}