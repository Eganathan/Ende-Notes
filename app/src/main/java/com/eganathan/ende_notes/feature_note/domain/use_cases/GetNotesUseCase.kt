package com.eganathan.ende_notes.feature_note.domain.use_cases

import com.eganathan.ende_notes.feature_note.domain.model.Note
import com.eganathan.ende_notes.feature_note.domain.repository.NoteRepository
import com.eganathan.ende_notes.feature_note.domain.util.NoteOrder
import com.eganathan.ende_notes.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(private val repository: NoteRepository) {

    //operator overloading so we can call the class as a function
    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when (noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Color -> notes.sortedBy { it.color}
                        is NoteOrder.Date -> notes.sortedBy { it.timeStamp}
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                    }
                }

                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Color -> notes.sortedByDescending { it.color}
                        is NoteOrder.Date -> notes.sortedByDescending { it.timeStamp}
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                    }
                }
            }
        }
    }

}