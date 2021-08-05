package ru.phoenigm.pokerman.holdem.service.combination

import ru.phoenigm.pokerman.holdem.domain.Combination
import ru.phoenigm.pokerman.holdem.domain.CombinationCategory
import ru.phoenigm.pokerman.holdem.domain.HandAndBoard

class FlushCombinationChecker : CombinationChecker {

    override fun checkCombination(handAndBoard: HandAndBoard): Combination? {
        val winningSuitCardLine = handAndBoard.cards
            .groupBy { it.suit }
            .filter { it.value.size >= 5 }
            .values.firstOrNull()
        return if (winningSuitCardLine == null) {
            null
        } else {
            val winningCards = winningSuitCardLine.sorted()
                .slice(winningSuitCardLine.size - 5 until winningSuitCardLine.size)
            Combination(CombinationCategory.FLUSH, winningCards)
        }
    }

}
