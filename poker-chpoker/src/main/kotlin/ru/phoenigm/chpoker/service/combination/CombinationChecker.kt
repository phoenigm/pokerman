package ru.phoenigm.chpoker.service.combination

import ru.phoenigm.chpoker.domain.Combination
import ru.phoenigm.chpoker.domain.HandAndBoard

interface CombinationChecker {

    fun checkCombination(handAndBoard: HandAndBoard): Combination?

}
