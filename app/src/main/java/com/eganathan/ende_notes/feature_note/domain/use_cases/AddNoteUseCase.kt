package com.eganathan.ende_notes.feature_note.domain.use_cases

import com.eganathan.ende_notes.feature_note.domain.model.InvalidNoteException
import com.eganathan.ende_notes.feature_note.domain.model.Note
import com.eganathan.ende_notes.feature_note.domain.repository.NoteRepository

class AddNoteUseCase(private val repository: NoteRepository) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException(message = "The title of the can't be empty")
        } else if (note.content.isBlank()) {
            throw InvalidNoteException(message = "The contents of the can't be empty")
        } else
            repository.insetNote(note)
    }
}