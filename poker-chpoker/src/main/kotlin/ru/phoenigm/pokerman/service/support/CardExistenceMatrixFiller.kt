package ru.phoenigm.pokerman.service.support

import ru.phoenigm.pokerman.domain.CardValue
import ru.phoenigm.pokerman.domain.HandAndBoard

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