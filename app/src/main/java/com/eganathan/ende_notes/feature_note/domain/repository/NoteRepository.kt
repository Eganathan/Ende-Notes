package com.eganathan.ende_notes.feature_note.domain.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eganathan.ende_notes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

//local fake repository for testing
//Interface of these operation belong to the domain layer
// the implementation needs to be inside the data layer / repository

interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insetNote(note: Note)

    suspend fun deleteNote(note: Note)

}