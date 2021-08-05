package ru.phoenigm.pokerman.holdem.service.support

import org.junit.jupiter.api.Test
import ru.phoenigm.pokerman.holdem.domain.Card
import ru.phoenigm.pokerman.holdem.domain.CardSuit
import ru.phoenigm.pokerman.holdem.domain.CardValue
import ru.phoenigm.pokerman.holdem.domain.HandAndBoard

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