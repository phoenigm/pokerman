package ru.phoenigm.pokerman.core.rules.combination

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import ru.phoenigm.pokerman.core.domain.*

internal class FlushCombinationCheckerTest {

    private val combinationChecker = FlushCombinationChecker()

    @EnumSource(value = CardSuit::class, names = ["DIAMONDS"], mode = EnumSource.Mode.EXCLUDE)
    @ParameterizedTest
    fun checkCombination(cardSuit: CardSuit) {
        val handAndBoard = HandAndBoard(
            listOf(
                Card(CardValue.TWO, CardSuit.DIAMONDS),
                Card(CardValue.SIX, cardSuit),
                Card(CardValue.THREE, cardSuit),
                Card(CardValue.KING, cardSuit),
                Card(CardValue.TEN, cardSuit),
                Card(CardValue.JACK, cardSuit),
                Card(CardValue.EIGHT, cardSuit),
            )
        )
        val winningCards = listOf(
            Card(CardValue.SIX, cardSuit),
            Card(CardValue.EIGHT, cardSuit),
            Card(CardValue.TEN, cardSuit),
            Card(CardValue.JACK, cardSuit),
            Card(CardValue.KING, cardSuit),
        )
        val expected = Combination(CombinationCategory.FLUSH, winningCards)

        val actual = combinationChecker.checkCombination(handAndBoard)

        assertEquals(expected, actual)
    }
}