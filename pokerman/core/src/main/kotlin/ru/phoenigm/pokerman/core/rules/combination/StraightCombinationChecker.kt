package ru.phoenigm.pokerman.core.rules.combination

import ru.phoenigm.pokerman.core.domain.Card
import ru.phoenigm.pokerman.core.domain.Combination
import ru.phoenigm.pokerman.core.domain.CombinationCategory
import ru.phoenigm.pokerman.core.domain.HandAndBoard
import ru.phoenigm.pokerman.core.rules.support.CardExistenceMatrix
import ru.phoenigm.pokerman.core.rules.support.CardExistenceMatrixFiller
import ru.phoenigm.pokerman.core.rules.support.SortedCardValueRange

class StraightCombinationChecker : CombinationChecker {
    private val matrixFiller: CardExistenceMatrixFiller = CardExistenceMatrixFiller()

    private companion object {
        const val COMBINATION_SHIFT = 4
    }

    override fun checkCombination(handAndBoard: HandAndBoard): Combination? {
        val existenceMatrix = matrixFiller.createFilledMatrix(handAndBoard)
        val winningCardCandidates = mutableSetOf<List<Card>>()

        (0 until CardExistenceMatrix.COLUMNS - COMBINATION_SHIFT).forEach { column ->
            val straightExists = existenceMatrix.checkRowIgnoreSuit(column, column + COMBINATION_SHIFT)
            if (straightExists) {
                winningCardCandidates.add(collectWinningCards(existenceMatrix, column))
            }
        }
        return if (winningCardCandidates.isNotEmpty()) {
            Combination(CombinationCategory.STRAIGHT, winningCardCandidates.last())
        } else {
            null
        }
    }

    private fun collectWinningCards(existenceMatrix: CardExistenceMatrix, column: Int): List<Card> {
        return (column..column + COMBINATION_SHIFT).map {
            Card(SortedCardValueRange.get(it), existenceMatrix.firstCardSuitInColumn(it))
        }
    }

}
