package com.eganathan.ende_notes.di

import android.app.Application
import androidx.room.Room
import com.eganathan.ende_notes.feature_note.data.data_source.NoteDataBase
import com.eganathan.ende_notes.feature_note.data.repository.NoteRepositoryImpl
import com.eganathan.ende_notes.feature_note.domain.repository.NoteRepository
import com.eganathan.ende_notes.feature_note.domain.use_cases.DeleteNoteUserCase
import com.eganathan.ende_notes.feature_note.domain.use_cases.GetNotesUseCase
import com.eganathan.ende_notes.feature_note.domain.use_cases.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDataBase(app: Application): NoteDataBase {

        return Room.databaseBuilder(
            context = app,
            klass = NoteDataBase::class.java,
            name = NoteDataBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDataBase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUserCase = DeleteNoteUserCase(repository)
        )
    }
}