package ru.phoenigm.chpoker.service.combination

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import ru.phoenigm.chpoker.domain.*

internal class QuadsCombinationCheckerTest {

    private val combinationChecker = QuadsCombinationChecker()

    @EnumSource(value = CardValue::class, names = ["FIVE", "TWO"], mode = EnumSource.Mode.EXCLUDE)
    @ParameterizedTest
    fun checkCombination(cardValue: CardValue) {
        val handAndBoard = HandAndBoard(
            listOf(
                Card(cardValue, CardSuit.CLUBS),
                Card(cardValue, CardSuit.SPRADES),
                Card(cardValue, CardSuit.DIAMONDS),
                Card(cardValue, CardSuit.HEATS),
                Card(CardValue.TWO, CardSuit.DIAMONDS),
                Card(CardValue.FIVE, CardSuit.HEATS),
                Card(CardValue.FIVE, CardSuit.DIAMONDS),
            )
        )
        val winningCards = listOf(
            Card(cardValue, CardSuit.CLUBS),
            Card(cardValue, CardSuit.SPRADES),
            Card(cardValue, CardSuit.DIAMONDS),
            Card(cardValue, CardSuit.HEATS),
            Card(CardValue.FIVE, CardSuit.HEATS)
        )
        val expected = Combination(CombinationCategory.FOUR_OF_A_KIND, winningCards)

        val actual = combinationChecker.checkCombination(handAndBoard)

        assertEquals(expected, actual)
    }
}