package ru.phoenigm.chpoker.service.combination

import ru.phoenigm.chpoker.domain.Card
import ru.phoenigm.chpoker.domain.Combination
import ru.phoenigm.chpoker.domain.CombinationCategory
import ru.phoenigm.chpoker.domain.HandAndBoard
import ru.phoenigm.chpoker.service.KickerListCollector

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