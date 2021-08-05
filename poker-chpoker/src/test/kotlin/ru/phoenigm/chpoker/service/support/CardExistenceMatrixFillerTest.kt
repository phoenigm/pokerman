package ru.phoenigm.chpoker.service.support

import org.junit.jupiter.api.Test
import ru.phoenigm.chpoker.domain.Card
import ru.phoenigm.chpoker.domain.CardSuit
import ru.phoenigm.chpoker.domain.CardValue
import ru.phoenigm.chpoker.domain.HandAndBoard
import ru.phoenigm.chpoker.service.support.CardExistenceMatrixFiller

internal class CardExistenceMatrixFillerTest {

    private val matrixFiller: CardExistenceMatrixFiller = CardExistenceMatrixFiller()

    @Test
    fun createFilledMatrix() {
        val handAndBoard = HandAndBoard(
            listOf(
                Card(CardValue.ACE, CardSuit.CLUBS),
                Card(CardValue.ACE, CardSuit.DIAMONDS),
                Card(CardValue.ACE, CardSuit.SPRADES),
                Card(CardValue.KING, CardSuit.CLUBS),
                Card(CardValue.TEN, CardSuit.CLUBS),
                Card(CardValue.JACK, CardSuit.CLUBS),
                Card(CardValue.QUEEN, CardSuit.CLUBS),
            )
        )
        val matrix = matrixFiller.createFilledMatrix(handAndBoard)

        println(matrix)
    }
}