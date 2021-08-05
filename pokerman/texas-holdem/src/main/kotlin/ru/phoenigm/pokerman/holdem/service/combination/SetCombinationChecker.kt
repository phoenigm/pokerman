package ru.phoenigm.pokerman.holdem.service.combination

import ru.phoenigm.pokerman.holdem.domain.Card
import ru.phoenigm.pokerman.holdem.domain.Combination
import ru.phoenigm.pokerman.holdem.domain.CombinationCategory
import ru.phoenigm.pokerman.holdem.domain.HandAndBoard
import ru.phoenigm.pokerman.holdem.service.KickerListCollector
import ru.phoenigm.pokerman.holdem.service.comparator.WinningCombinationDeterminer

class SetCombinationChecker : CombinationChecker {
    private val winningCombinationDeterminer: WinningCombinationDeterminer = WinningCombinationDeterminer()
    private val kickerListCollector: KickerListCollector = KickerListCollector()

    override fun checkCombination(handAndBoard: HandAndBoard): Combination? {
        val setCandidates = handAndBoard.cards
            .groupBy { it.value }
            .filter { it.value.size == 3 }

        return if (setCandidates.isNotEmpty()) {
            val set = winningCombinationDeterminer.determine(setCandidates.values)
            buildCombination(set, handAndBoard)
        } else {
            null
        }
    }

    private fun buildCombination(pair: List<Card>, handAndBoard: HandAndBoard): Combination {
        return Combination(
            CombinationCategory.THREE_OF_A_KIND,
            pair + kickerListCollector.collectKickerList(handAndBoard, pair, 2)
        )
    }
}