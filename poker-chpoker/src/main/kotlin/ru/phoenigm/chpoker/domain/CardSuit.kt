package ru.phoenigm.chpoker.domain

enum class CardSuit {
    /**
     * Бубны
     */
    DIAMONDS,

    /**
     * Червы
     */
    HEATS,

    /**
     * Пики
     */
    SPRADES,

    /**
     * Крести
     */
    CLUBS;

    companion object {
        private val values: Array<CardSuit> = values()

        fun getByOrdinal(ordinal: Int): CardSuit = values[ordinal]
    }

    override fun toString(): String {
        val suitSymbols = listOf("♦", "♥", "♠", "♣")
        return suitSymbols[this.ordinal]
    }

}