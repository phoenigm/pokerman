package ru.phoenigm.pokerman.domain

data class Hand(
    val firstCard: Card,
    val secondCard: Card
) {
    override fun toString(): String {
        return "$firstCard $secondCard"
    }
}
