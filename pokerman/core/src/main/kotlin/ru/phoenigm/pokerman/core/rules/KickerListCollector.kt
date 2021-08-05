package ru.phoenigm.pokerman.core.rules

import ru.phoenigm.pokerman.core.domain.Card
import ru.phoenigm.pokerman.core.domain.HandAndBoard

class KickerListCollector {

    fun collectKickerList(handAndBoard: HandAndBoard, mainCombination: List<Card>, kickerListSize: Int): List<Card> {
        val kickerCandidates = handAndBoard.cards - mainCombination
        return kickerCandidates.sortedDescending()
            .slice(0 until kickerListSize)
    }
}