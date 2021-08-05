package ru.phoenigm.pokerman.service.combination

import ru.phoenigm.pokerman.domain.Combination
import ru.phoenigm.pokerman.domain.HandAndBoard

interface CombinationChecker {

    fun checkCombination(handAndBoard: HandAndBoard): Combination?

}
