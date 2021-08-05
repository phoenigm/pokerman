package ru.phoenigm.pokerman.service.combination

import ru.phoenigm.pokerman.domain.Card
import ru.phoenigm.pokerman.domain.Combination
import ru.phoenigm.pokerman.domain.CombinationCategory
import ru.phoenigm.pokerman.domain.HandAndBoard
import ru.phoenigm.pokerman.service.KickerListCollector
import ru.phoenigm.pokerman.service.comparator.WinningCombinationDeterminer

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