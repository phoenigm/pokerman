package ru.phoenigm.pokerman.holdem.service.support

import ru.phoenigm.pokerman.holdem.domain.CardValue
import ru.phoenigm.pokerman.holdem.domain.HandAndBoard

class CardExistenceMatrixFiller {

    fun createFilledMatrix(handAndBoard: HandAndBoard): CardExistenceMatrix {
        val cardExistenceMatrix = CardExistenceMatrix()
        handAndBoard.cards.forEach {
            cardExistenceMatrix.fillCell(it.suit.ordinal, it.value.ordinal + 1)
            if (it.value == CardValue.ACE) {
                cardExistenceMatrix.fillCell(it.suit.ordinal, 0)
            }
        }
        return cardExistenceMatrix
    }
}