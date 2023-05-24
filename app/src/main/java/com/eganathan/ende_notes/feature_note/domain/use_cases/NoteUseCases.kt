package com.eganathan.ende_notes.feature_note.domain.use_cases

// So we can pass the feature specific use-cases can be bundled
// up so it can be passed as a single param to the view model
data class NoteUseCases(
    var getNotesUseCase: GetNotesUseCase,
    var deleteNoteUserCase: DeleteNoteUserCase
)