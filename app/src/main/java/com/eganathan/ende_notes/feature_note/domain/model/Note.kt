package com.eganathan.ende_notes.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eganathan.ende_notes.ui.theme.SoftGreen
import com.eganathan.ende_notes.ui.theme.SoftPurple
import com.eganathan.ende_notes.ui.theme.SoftYellow
import com.eganathan.ende_notes.ui.theme.TwillightLavander

@Entity
data class Note(
    val title: String,
    val content: String,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(SoftGreen, SoftPurple, SoftYellow, TwillightLavander)
    }
}
