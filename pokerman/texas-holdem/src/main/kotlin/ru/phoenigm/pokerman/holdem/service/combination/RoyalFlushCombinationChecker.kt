package ru.phoenigm.pokerman.holdem.service.combination

import ru.phoenigm.pokerman.holdem.domain.*
import ru.phoenigm.pokerman.holdem.service.support.CardExistenceMatrix
import ru.phoenigm.pokerman.holdem.service.support.CardExistenceMatrixFiller
import ru.phoenigm.pokerman.holdem.service.support.SortedCardValueRange

class RoyalFlushCombinationChecker : CombinationChecker {
    private val matrixFiller: CardExistenceMatrixFiller = CardExistenceMatrixFiller()

    private companion object {
        const val ROYAL_FLUSH_START_POSITION = 9
        const val ROYAL_FLUSH_END_POSITION = 13
    }

    override fun checkCombination(handAndBoard: HandAndBoard): Combination? {
        val existenceMatrix = matrixFiller.createFilledMatrix(handAndBoard)
        (0 until CardExistenceMatrix.ROWS).forEach {
            val royalFlushExists = existenceMatrix.checkRow(it, ROYAL_FLUSH_START_POSITION, ROYAL_FLUSH_END_POSITION)
            if (royalFlushExists) {
                return Combination(
                    CombinationCategory.ROYAL_FLUSH,
                    collectWinningCards(it)
                )
            }
        }
        return null
    }

    private fun collectWinningCards(rowNumber: Int): List<Card> {
        val cardSuit = CardSuit.getByOrdinal(rowNumber)
        return (ROYAL_FLUSH_START_POSITION..ROYAL_FLUSH_END_POSITION).map {
            Card(SortedCardValueRange.get(it), cardSuit)
        }
    }
}