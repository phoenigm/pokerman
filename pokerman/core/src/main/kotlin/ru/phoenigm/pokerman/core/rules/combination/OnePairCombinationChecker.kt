package ru.phoenigm.pokerman.core.rules.combination

import ru.phoenigm.pokerman.core.domain.Card
import ru.phoenigm.pokerman.core.domain.Combination
import ru.phoenigm.pokerman.core.domain.CombinationCategory
import ru.phoenigm.pokerman.core.domain.HandAndBoard
import ru.phoenigm.pokerman.core.rules.KickerListCollector
import ru.phoenigm.pokerman.core.rules.comparator.WinningCombinationDeterminer

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