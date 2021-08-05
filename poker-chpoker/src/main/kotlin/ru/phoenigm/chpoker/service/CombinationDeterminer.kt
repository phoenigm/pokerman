package ru.phoenigm.chpoker.service

import ru.phoenigm.chpoker.domain.HandAndBoard
import ru.phoenigm.chpoker.service.combination.*

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