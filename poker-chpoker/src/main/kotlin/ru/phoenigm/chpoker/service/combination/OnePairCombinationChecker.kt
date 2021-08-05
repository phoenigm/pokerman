package ru.phoenigm.chpoker.service.combination

import ru.phoenigm.chpoker.domain.Card
import ru.phoenigm.chpoker.domain.Combination
import ru.phoenigm.chpoker.domain.CombinationCategory
import ru.phoenigm.chpoker.domain.HandAndBoard
import ru.phoenigm.chpoker.service.KickerListCollector
import ru.phoenigm.chpoker.service.comparator.WinningCombinationDeterminer

class OnePairCombinationChecker : CombinationChecker {
    private val winningCombinationDeterminer: WinningCombinationDeterminer = WinningCombinationDeterminer()
    private val kickerListCollector: KickerListCollector = KickerListCollector()

    override fun checkCombination(handAndBoard: HandAndBoard): Combination? {
        val pairCandidates = handAndBoard.cards
            .groupBy { it.value }
            .filter { it.value.size == 2 }

        return if (pairCandidates.isNotEmpty()) {
            val pair = winningCombinationDeterminer.determine(pairCandidates.values)
            buildCombination(pair, handAndBoard)
        } else {
            null
        }
    }

    private fun buildCombination(pair: List<Card>, handAndBoard: HandAndBoard): Combination {
        return Combination(
            CombinationCategory.ONE_PAIR,
            pair + kickerListCollector.collectKickerList(handAndBoard, pair, 3)
        )
    }
}