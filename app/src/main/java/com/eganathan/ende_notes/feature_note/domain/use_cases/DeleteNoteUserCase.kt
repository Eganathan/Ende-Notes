package com.eganathan.ende_notes.feature_note.domain.use_cases

import com.eganathan.ende_notes.feature_note.domain.model.Note
import com.eganathan.ende_notes.feature_note.domain.repository.NoteRepository

class DeleteNoteUserCase(private val repository: NoteRepository) {

    suspend operator fun invoke(note: Note) {
        return repository.deleteNote(note)
    }
}