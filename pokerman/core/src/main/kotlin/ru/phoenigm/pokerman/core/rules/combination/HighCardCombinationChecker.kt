package ru.phoenigm.pokerman.core.rules.combination

import ru.phoenigm.pokerman.core.domain.Combination
import ru.phoenigm.pokerman.core.domain.CombinationCategory
import ru.phoenigm.pokerman.core.domain.HandAndBoard
import ru.phoenigm.pokerman.core.rules.KickerListCollector

class HighCardCombinationChecker : CombinationChecker {
    private val kickerListCollector: KickerListCollector = KickerListCollector()

    override fun checkCombination(handAndBoard: HandAndBoard): Combination {
        return Combination(
            CombinationCategory.HIGH_CARD,
            kickerListCollector.collectKickerList(handAndBoard, listOf(), 5)
        )
    }
}