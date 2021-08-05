package ru.phoenigm.chpoker.service.combination

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import ru.phoenigm.chpoker.domain.*

internal class TwoPairsCombinationCheckerTest {

    private val combinationChecker = TwoPairsCombinationChecker()

    @EnumSource(value = CardValue::class, names = ["FIVE", "TWO", "FOUR", "KING"], mode = EnumSource.Mode.EXCLUDE)
    @ParameterizedTest
    fun checkCombination(cardValue: CardValue) {
        val handAndBoard = HandAndBoard(
            listOf(
                Card(cardValue, CardSuit.CLUBS),
                Card(cardValue, CardSuit.SPRADES),
                Card(CardValue.TWO, CardSuit.DIAMONDS),
                Card(CardValue.TWO, CardSuit.HEATS),
                Card(CardValue.FOUR, CardSuit.DIAMONDS),
                Card(CardValue.FIVE, CardSuit.HEATS),
                Card(CardValue.KING, CardSuit.DIAMONDS),
            )
        )
        val winningCards = listOf(
            Card(cardValue, CardSuit.CLUBS),
            Card(cardValue, CardSuit.SPRADES),
            Card(CardValue.TWO, CardSuit.DIAMONDS),
            Card(CardValue.TWO, CardSuit.HEATS),
            Card(CardValue.KING, CardSuit.DIAMONDS)
        )
        val expected = Combination(CombinationCategory.TWO_PAIRS, winningCards)

        val actual = combinationChecker.checkCombination(handAndBoard)

        assertEquals(expected, actual)
    }
}