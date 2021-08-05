package ru.phoenigm.pokerman.core.rules.combination

import ru.phoenigm.pokerman.core.domain.Combination
import ru.phoenigm.pokerman.core.domain.HandAndBoard

interface CombinationChecker {

    fun checkCombination(handAndBoard: HandAndBoard): Combination?

}
