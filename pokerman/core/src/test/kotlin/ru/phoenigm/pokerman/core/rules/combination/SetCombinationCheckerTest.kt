package ru.phoenigm.pokerman.core.rules.combination

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import ru.phoenigm.pokerman.core.domain.*

internal class SetCombinationCheckerTest {

    private val combinationChecker = SetCombinationChecker()

    @EnumSource(value = CardValue::class, names = ["FIVE", "TWO", "FOUR", "KING"], mode = EnumSource.Mode.EXCLUDE)
    @ParameterizedTest
    fun checkCombination(cardValue: CardValue) {
        val handAndBoard = HandAndBoard(
            listOf(
                Card(cardValue, CardSuit.CLUBS),
                Card(cardValue, CardSuit.SPRADES),
                Card(cardValue, CardSuit.DIAMONDS),
                Card(CardValue.FOUR, CardSuit.HEATS),
                Card(CardValue.TWO, CardSuit.DIAMONDS),
                Card(CardValue.FIVE, CardSuit.HEATS),
                Card(CardValue.KING, CardSuit.DIAMONDS),
            )
        )
        val winningCards = listOf(
            Card(cardValue, CardSuit.CLUBS),
            Card(cardValue, CardSuit.SPRADES),
            Card(cardValue, CardSuit.DIAMONDS),
            Card(CardValue.KING, CardSuit.DIAMONDS),
            Card(CardValue.FIVE, CardSuit.HEATS)
        )
        val expected = Combination(CombinationCategory.THREE_OF_A_KIND, winningCards)

        val actual = combinationChecker.checkCombination(handAndBoard)

        assertEquals(expected, actual)
    }
}