package ru.phoenigm.pokerman.core.rules.combination

import ru.phoenigm.pokerman.core.domain.*
import ru.phoenigm.pokerman.core.rules.comparator.WinningCombinationDeterminer
import ru.phoenigm.pokerman.core.rules.support.CardExistenceMatrix
import ru.phoenigm.pokerman.core.rules.support.CardExistenceMatrixFiller
import ru.phoenigm.pokerman.core.rules.support.SortedCardValueRange

class StraightFlushCombinationChecker : CombinationChecker {
    private val matrixFiller: CardExistenceMatrixFiller = CardExistenceMatrixFiller()
    private val winningCombinationDeterminer: WinningCombinationDeterminer = WinningCombinationDeterminer()

    private companion object {
        const val COMBINATION_SHIFT = 4
    }

    override fun checkCombination(handAndBoard: HandAndBoard): Combination? {
        val existenceMatrix = matrixFiller.createFilledMatrix(handAndBoard)
        val winningCardCandidates = mutableSetOf<List<Card>>()

        (0 until CardExistenceMatrix.ROWS).forEach { row ->
            (0 until CardExistenceMatrix.COLUMNS - COMBINATION_SHIFT).forEach { column ->
                val straightFlushExists = existenceMatrix.checkRow(row, column, column + COMBINATION_SHIFT)
                if (straightFlushExists) {
                    winningCardCandidates.add(collectWinningCards(row, column, column + COMBINATION_SHIFT))
                }
            }
        }
        return if (winningCardCandidates.isNotEmpty()) {
            Combination(
                CombinationCategory.STRAIGHT_FLUSH,
                winningCombinationDeterminer.determine(winningCardCandidates)
            )
        } else {
            null
        }
    }

    private fun collectWinningCards(rowNumber: Int, startPos: Int, endPos: Int): List<Card> {
        val cardSuit = CardSuit.getByOrdinal(rowNumber)
        return (startPos..endPos).map {
            Card(SortedCardValueRange.get(it), cardSuit)
        }
    }
}