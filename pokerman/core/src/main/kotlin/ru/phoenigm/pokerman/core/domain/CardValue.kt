package ru.phoenigm.pokerman.core.domain

enum class CardValue(val order: Int) {
    TWO(2),
    THREE(3),
    FOUR(3),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(1);

    companion object {
        private val values: Array<CardValue> = values()

        fun getByOrdinal(ordinal: Int): CardValue = values[ordinal]

    }

    override fun toString(): String {
        val cardValuesSymbols = listOf("2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A")
        return cardValuesSymbols[this.ordinal]
    }
}