package com.eganathan.ende_notes.feature_note.presentation.util

sealed class Screen(val route:String) {

    object NotesScreen: Screen("notes_screen")
    object NoteScreen: Screen("note_detail_screen")
}

object NavArguments{

    const val noteId = "noteId"
    const val noteColor = "noteColor"
}