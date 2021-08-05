package ru.phoenigm.pokerman.holdem.service.combination

import ru.phoenigm.pokerman.holdem.domain.Combination
import ru.phoenigm.pokerman.holdem.domain.CombinationCategory
import ru.phoenigm.pokerman.holdem.domain.HandAndBoard
import ru.phoenigm.pokerman.holdem.service.KickerListCollector

class HighCardCombinationChecker : CombinationChecker {
    private val kickerListCollector: KickerListCollector = KickerListCollector()

    override fun checkCombination(handAndBoard: HandAndBoard): Combination {
        return Combination(
            CombinationCategory.HIGH_CARD,
            kickerListCollector.collectKickerList(handAndBoard, listOf(), 5)
        )
    }
}