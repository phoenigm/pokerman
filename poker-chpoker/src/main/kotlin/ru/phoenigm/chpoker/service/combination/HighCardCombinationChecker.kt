package ru.phoenigm.chpoker.service.combination

import ru.phoenigm.chpoker.domain.Combination
import ru.phoenigm.chpoker.domain.CombinationCategory
import ru.phoenigm.chpoker.domain.HandAndBoard
import ru.phoenigm.chpoker.service.KickerListCollector

class HighCardCombinationChecker : CombinationChecker {
    private val kickerListCollector: KickerListCollector = KickerListCollector()

    override fun checkCombination(handAndBoard: HandAndBoard): Combination {
        return Combination(
            CombinationCategory.HIGH_CARD,
            kickerListCollector.collectKickerList(handAndBoard, listOf(), 5)
        )
    }
}