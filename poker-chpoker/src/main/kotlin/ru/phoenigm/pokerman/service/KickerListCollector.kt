package ru.phoenigm.pokerman.service

import ru.phoenigm.pokerman.domain.Card
import ru.phoenigm.pokerman.domain.HandAndBoard

class KickerListCollector {

    fun collectKickerList(handAndBoard: HandAndBoard, mainCombination: List<Card>, kickerListSize: Int): List<Card> {
        val kickerCandidates = handAndBoard.cards - mainCombination
        return kickerCandidates.sortedDescending()
            .slice(0 until kickerListSize)
    }
}