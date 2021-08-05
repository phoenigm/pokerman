package ru.phoenigm.pokerman.service.combination

import ru.phoenigm.pokerman.domain.Combination
import ru.phoenigm.pokerman.domain.CombinationCategory
import ru.phoenigm.pokerman.domain.HandAndBoard
import ru.phoenigm.pokerman.service.KickerListCollector

class HighCardCombinationChecker : CombinationChecker {
    private val kickerListCollector: KickerListCollector = KickerListCollector()

    override fun checkCombination(handAndBoard: HandAndBoard): Combination {
        return Combination(
            CombinationCategory.HIGH_CARD,
            kickerListCollector.collectKickerList(handAndBoard, listOf(), 5)
        )
    }
}