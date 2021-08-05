package ru.phoenigm.pokerman.core.rules.combination

import ru.phoenigm.pokerman.core.domain.Combination
import ru.phoenigm.pokerman.core.domain.CombinationCategory
import ru.phoenigm.pokerman.core.domain.HandAndBoard

class FullHouseCombinationChecker : CombinationChecker {

    override fun checkCombination(handAndBoard: HandAndBoard): Combination? {
        val mapper = handAndBoard.cards.groupBy { it.value }
        val threeMapper = mapper.filter { it.value.size == 3 }
        val twoMapper = mapper.filter { it.value.size == 2 }
        val twoThreeMapper = mapper.filter { it.value.size >= 2 }

        return if (threeMapper.isNotEmpty() && twoMapper.isNotEmpty()) {
            val threeEntry = threeMapper.toSortedMap().entries.last()
            val (threeCardValue, three) = threeEntry
            val two = (twoThreeMapper - threeCardValue).toSortedMap().entries.last().value
            Combination(CombinationCategory.FULL_HOUSE, three + two)
        } else {
            null
        }
    }

}