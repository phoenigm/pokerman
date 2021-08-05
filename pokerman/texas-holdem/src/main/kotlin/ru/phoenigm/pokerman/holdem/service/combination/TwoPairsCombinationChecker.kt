package ru.phoenigm.pokerman.holdem.service.combination

import ru.phoenigm.pokerman.holdem.domain.Card
import ru.phoenigm.pokerman.holdem.domain.Combination
import ru.phoenigm.pokerman.holdem.domain.CombinationCategory
import ru.phoenigm.pokerman.holdem.domain.HandAndBoard
import ru.phoenigm.pokerman.holdem.service.KickerListCollector
import ru.phoenigm.pokerman.holdem.service.comparator.WinningCombinationDeterminer

class TwoPairsCombinationChecker : CombinationChecker {
    private val winningCombinationDeterminer: WinningCombinationDeterminer = WinningCombinationDeterminer()
    private val kickerListCollector: KickerListCollector = KickerListCollector()

    override fun checkCombination(handAndBoard: HandAndBoard): Combination? {
        val twoPairsMapper = handAndBoard.cards
            .groupBy { it.value }
            .filter { it.value.size == 2 }

        return if (twoPairsMapper.size >= 2) {
            var twoPairsCandidates = twoPairsMapper.values
            val highPair = winningCombinationDeterminer.determine(twoPairsCandidates)
            twoPairsCandidates -= listOf(highPair)
            val lowPair = winningCombinationDeterminer.determine(twoPairsCandidates)
            buildCombination(highPair + lowPair, handAndBoard)
        } else {
            null
        }
    }

    private fun buildCombination(pair: List<Card>, handAndBoard: HandAndBoard): Combination {
        return Combination(
            CombinationCategory.TWO_PAIRS,
            pair + kickerListCollector.collectKickerList(handAndBoard, pair, 1)
        )
    }
}