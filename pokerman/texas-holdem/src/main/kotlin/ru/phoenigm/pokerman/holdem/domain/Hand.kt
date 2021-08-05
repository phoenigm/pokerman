package ru.phoenigm.pokerman.holdem.domain

data class Hand(
    val firstCard: Card,
    val secondCard: Card
) {
    override fun toString(): String {
        return "$firstCard $secondCard"
    }
}
