package ru.phoenigm.pokerman.core.domain

data class Card(
    val value: CardValue,
    val suit: CardSuit
) : Comparable<Card> {

    override fun compareTo(other: Card): Int {
        return if (this.value.ordinal != other.value.ordinal) {
            this.value.ordinal - other.value.ordinal
        } else {
            this.suit.ordinal - other.suit.ordinal
        }
    }

    override fun toString(): String {
        return "$value$suit"
    }

}
