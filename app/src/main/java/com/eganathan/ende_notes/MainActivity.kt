package com.eganathan.ende_notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.eganathan.ende_notes.feature_note.presentation.Note.NoteDetailScreen
import com.eganathan.ende_notes.feature_note.presentation.notes.NotesScreen
import com.eganathan.ende_notes.feature_note.presentation.util.NavArguments
import com.eganathan.ende_notes.feature_note.presentation.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Surface() {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screen.NotesScreen.route,
                ) {

                    composable(route = Screen.NotesScreen.route) {
                        NotesScreen(navController = navController)
                    }

                    composable(
                        route = Screen.NoteScreen.route.plus("?${NavArguments.noteId}{noteId}&${NavArguments.noteColor}={noteColor}"),
                        arguments = listOf(
                            navArgument(name = NavArguments.noteId) {
                                type = NavType.IntType
                                defaultValue = -1
                            },
                            navArgument(name = NavArguments.noteColor) {
                                type = NavType.IntType
                                defaultValue = -1
                            },
                        )
                    ) {
                        val color = it.arguments?.getInt(NavArguments.noteColor) ?: -1
                        NoteDetailScreen(navController = navController, noteColor = color)
                    }

                }

            }

        }
    }
}
