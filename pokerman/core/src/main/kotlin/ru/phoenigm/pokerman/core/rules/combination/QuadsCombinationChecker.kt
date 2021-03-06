package ru.phoenigm.pokerman.core.rules.combination

import ru.phoenigm.pokerman.core.domain.Card
import ru.phoenigm.pokerman.core.domain.Combination
import ru.phoenigm.pokerman.core.domain.CombinationCategory
import ru.phoenigm.pokerman.core.domain.HandAndBoard
import ru.phoenigm.pokerman.core.rules.KickerListCollector

class QuadsCombinationChecker : CombinationChecker {
    private val kickerListCollector: KickerListCollector = KickerListCollector()

    override fun checkCombination(handAndBoard: HandAndBoard): Combination? {
        val quadsMapper = handAndBoard.cards
            .groupBy { it.value }
            .filter { it.value.size == 4 }

        return if (quadsMapper.isNotEmpty()) {
            val quads = quadsMapper.entries.first().value
            buildCombination(quads, handAndBoard)
        } else {
            null
        }
    }

    private fun buildCombination(pair: List<Card>, handAndBoard: HandAndBoard): Combination {
        return Combination(
            CombinationCategory.FOUR_OF_A_KIND,
            pair + kickerListCollector.collectKickerList(handAndBoard, pair, 1)
        )
    }
}