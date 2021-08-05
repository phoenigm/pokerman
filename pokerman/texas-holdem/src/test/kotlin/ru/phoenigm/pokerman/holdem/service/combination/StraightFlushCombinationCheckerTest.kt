package ru.phoenigm.pokerman.holdem.service.combination

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import ru.phoenigm.pokerman.holdem.domain.*

internal class StraightFlushCombinationCheckerTest {

    private val combinationChecker = StraightFlushCombinationChecker()

    @EnumSource(value = CardSuit::class)
    @ParameterizedTest
    fun checkCombination(cardSuit: CardSuit) {
        val handAndBoard = HandAndBoard(
            listOf(
                Card(CardValue.ACE, cardSuit),
                Card(CardValue.ACE, CardSuit.DIAMONDS),
                Card(CardValue.ACE, CardSuit.SPRADES),
                Card(CardValue.TWO, cardSuit),
                Card(CardValue.THREE, cardSuit),
                Card(CardValue.FIVE, cardSuit),
                Card(CardValue.FOUR, cardSuit),
            )
        )
        val winningCards = listOf(
            Card(CardValue.ACE, cardSuit),
            Card(CardValue.TWO, cardSuit),
            Card(CardValue.THREE, cardSuit),
            Card(CardValue.FOUR, cardSuit),
            Card(CardValue.FIVE, cardSuit),
        )
        val expected = Combination(CombinationCategory.STRAIGHT_FLUSH, winningCards)

        val actual = combinationChecker.checkCombination(handAndBoard)

        assertEquals(expected, actual)
    }

    @EnumSource(value = CardSuit::class)
    @ParameterizedTest
    fun checkCombinationRoyalFlush(cardSuit: CardSuit) {
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
        val expected = Combination(CombinationCategory.STRAIGHT_FLUSH, winningCards)

        val actual = combinationChecker.checkCombination(handAndBoard)

        assertEquals(expected, actual)
    }

    @EnumSource(value = CardSuit::class)
    @ParameterizedTest
    fun checkCombination2(cardSuit: CardSuit) {
        val handAndBoard = HandAndBoard(
            listOf(
                Card(CardValue.FOUR, cardSuit),
                Card(CardValue.ACE, CardSuit.DIAMONDS),
                Card(CardValue.FIVE, cardSuit),
                Card(CardValue.SIX, cardSuit),
                Card(CardValue.SEVEN, cardSuit),
                Card(CardValue.EIGHT, cardSuit),
                Card(CardValue.NINE, cardSuit),
            )
        )
        val winningCards = listOf(
            Card(CardValue.FIVE, cardSuit),
            Card(CardValue.SIX, cardSuit),
            Card(CardValue.SEVEN, cardSuit),
            Card(CardValue.EIGHT, cardSuit),
            Card(CardValue.NINE, cardSuit),
        ).sorted()
        val expected = Combination(CombinationCategory.STRAIGHT_FLUSH, winningCards)

        val actual = combinationChecker.checkCombination(handAndBoard)

        assertEquals(expected, actual)
    }
}