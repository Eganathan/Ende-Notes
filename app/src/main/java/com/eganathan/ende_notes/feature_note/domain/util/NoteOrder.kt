package com.eganathan.ende_notes.feature_note.domain.util

sealed class NoteOrder(val orderType: OrderType) {
    class Title(orderType: OrderType) : NoteOrder(orderType)
    class Date(orderType: OrderType) : NoteOrder(orderType)
    class Color(orderType: OrderType) : NoteOrder(orderType)

    fun copy(newOrder: OrderType): NoteOrder {
        return when (this) {
            is Color -> Color(newOrder)
            is Date -> Date(newOrder)
            is Title -> Title(orderType)
        }
    }
}