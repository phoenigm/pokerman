package ru.phoenigm.pokerman.holdem.service.combination

import ru.phoenigm.pokerman.holdem.domain.Combination
import ru.phoenigm.pokerman.holdem.domain.HandAndBoard

interface CombinationChecker {

    fun checkCombination(handAndBoard: HandAndBoard): Combination?

}
