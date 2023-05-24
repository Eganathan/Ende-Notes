package com.eganathan.ende_notes.feature_note.domain.util

import androidx.room.Index

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}