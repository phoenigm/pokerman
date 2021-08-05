package ru.phoenigm.chpoker.service.combination

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import ru.phoenigm.chpoker.domain.*

internal class StraightCombinationCheckerTest {

    private val combinationChecker = StraightCombinationChecker()

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
            Card(CardValue.ACE, CardSuit.DIAMONDS),
            Card(CardValue.TWO, cardSuit),
            Card(CardValue.THREE, cardSuit),
            Card(CardValue.FOUR, cardSuit),
            Card(CardValue.FIVE, cardSuit),
        )
        val expected = Combination(CombinationCategory.STRAIGHT, winningCards)

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
            Card(CardValue.ACE, CardSuit.DIAMONDS),
            Card(CardValue.KING, cardSuit),
            Card(CardValue.TEN, cardSuit),
            Card(CardValue.JACK, cardSuit),
            Card(CardValue.QUEEN, cardSuit),
        ).sorted()
        val expected = Combination(CombinationCategory.STRAIGHT, winningCards)

        val actual = combinationChecker.checkCombination(handAndBoard)

        assertEquals(expected, actual)
    }

}