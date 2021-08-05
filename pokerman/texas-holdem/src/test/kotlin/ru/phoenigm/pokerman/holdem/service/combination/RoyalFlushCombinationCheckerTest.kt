package ru.phoenigm.pokerman.holdem.service.combination

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import ru.phoenigm.pokerman.holdem.domain.*

internal class RoyalFlushCombinationCheckerTest {

    private val combinationChecker = RoyalFlushCombinationChecker()

    @EnumSource(value = CardSuit::class)
    @ParameterizedTest
    fun checkCombination(cardSuit: CardSuit) {
        val handAndBoard = HandAndBoard(
            listOf(
                Card(CardValue.ACE, cardSuit),
                Card(CardValue.ACE, CardSuit.DIAMONDS),
                Card(CardValue.ACE, CardSuit.SPRADES),
                Card(CardValue.KING, cardSuit),
                Card(CardValue.TEN, cardSuit),
                Card(CardValue.JACK, cardSuit),
                Card(CardValue.QUEEN, cardSuit),
            )
        )
        val winningCards = listOf(
            Card(CardValue.ACE, cardSuit),
            Card(CardValue.KING, cardSuit),
            Card(CardValue.TEN, cardSuit),
            Card(CardValue.JACK, cardSuit),
            Card(CardValue.QUEEN, cardSuit),
        ).sorted()
        val expected = Combination(CombinationCategory.ROYAL_FLUSH, winningCards)

        val actual = combinationChecker.checkCombination(handAndBoard)

        assertEquals(expected, actual)
    }

}