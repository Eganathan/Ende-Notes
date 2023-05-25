package com.eganathan.ende_notes.feature_note.presentation.notes

import com.eganathan.ende_notes.feature_note.domain.model.Note
import com.eganathan.ende_notes.feature_note.domain.util.NoteOrder
import com.eganathan.ende_notes.feature_note.domain.util.OrderType

data class NotesStates(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSelectionVisible: Boolean = false
)