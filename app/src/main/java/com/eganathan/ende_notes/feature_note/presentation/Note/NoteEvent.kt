package com.eganathan.ende_notes.feature_note.presentation.Note

sealed class NoteEvent {
    data class EditedTitle(val value: String) : NoteEvent()
    data class EditedContent(val value: String) : NoteEvent()
    data class ChangeColor(val color: Int) : NoteEvent()
    object SaveNote: NoteEvent()
}
