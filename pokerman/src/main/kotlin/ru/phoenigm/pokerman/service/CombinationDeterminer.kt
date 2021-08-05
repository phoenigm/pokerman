package ru.phoenigm.pokerman.service

import ru.phoenigm.pokerman.domain.HandAndBoard
import ru.phoenigm.pokerman.service.combination.*

class CombinationDeterminer {

    private val combinationCheckers = listOf(
        RoyalFlushCombinationChecker(),
        StraightFlushCombinationChecker(),
        QuadsCombinationChecker(),
        FullHouseCombinationChecker(),
        FlushCombinationChecker(),
        StraightFlushCombinationChecker(),
        SetCombinationChecker(),
        TwoPairsCombinationChecker(),
        OnePairCombinationChecker(),
        HighCardCombinationChecker()
    )

    fun determineCombination(handAndBoard: HandAndBoard) = combinationCheckers.asSequence()
        .map { it.checkCombination(handAndBoard) }
        .first { it != null } ?: throw RuntimeException("Invalid combination checkers for board $handAndBoard")
}