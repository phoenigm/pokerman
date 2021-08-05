package ru.phoenigm.chpoker.service

import ru.phoenigm.chpoker.domain.Card
import ru.phoenigm.chpoker.domain.HandAndBoard

class KickerListCollector {

    fun collectKickerList(handAndBoard: HandAndBoard, mainCombination: List<Card>, kickerListSize: Int): List<Card> {
        val kickerCandidates = handAndBoard.cards - mainCombination
        return kickerCandidates.sortedDescending()
            .slice(0 until kickerListSize)
    }
}