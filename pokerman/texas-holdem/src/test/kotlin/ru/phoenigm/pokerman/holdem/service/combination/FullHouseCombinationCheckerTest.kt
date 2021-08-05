package ru.phoenigm.pokerman.holdem.service.combination

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import ru.phoenigm.pokerman.holdem.domain.*

internal class FullHouseCombinationCheckerTest {

    private val combinationChecker = FullHouseCombinationChecker()

    @EnumSource(value = CardValue::class, names = ["FIVE", "TWO", "ACE"], mode = EnumSource.Mode.EXCLUDE)
    @ParameterizedTest
    fun checkCombination(cardValue: CardValue) {
        val handAndBoard = HandAndBoard(
            listOf(
                Card(cardValue, CardSuit.CLUBS),
                Card(cardValue, CardSuit.SPRADES),
                Card(cardValue, CardSuit.DIAMONDS),
                Card(CardValue.ACE, CardSuit.HEATS),
                Card(CardValue.TWO, CardSuit.DIAMONDS),
                Card(CardValue.FIVE, CardSuit.HEATS),
                Card(CardValue.FIVE, CardSuit.DIAMONDS),
            )
        )
        val winningCards = listOf(
            Card(cardValue, CardSuit.CLUBS),
            Card(cardValue, CardSuit.SPRADES),
            Card(cardValue, CardSuit.DIAMONDS),
            Card(CardValue.FIVE, CardSuit.HEATS),
            Card(CardValue.FIVE, CardSuit.DIAMONDS)
        )
        val expected = Combination(CombinationCategory.FULL_HOUSE, winningCards)

        val actual = combinationChecker.checkCombination(handAndBoard)

        assertEquals(expected, actual)
    }
}