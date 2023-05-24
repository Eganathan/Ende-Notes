package com.eganathan.ende_notes.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eganathan.ende_notes.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)

abstract class NoteDataBase : RoomDatabase() {

    abstract val noteDao: NoteDao

}