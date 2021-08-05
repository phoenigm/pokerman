package ru.phoenigm.chpoker.service.comparator

import ru.phoenigm.chpoker.domain.Card

// TODO : fix it
//Azat: 2♠ K♣
//Damir: A♣ 4♦
//Rinat: A♦ 5♠
//******************
//* J♣ 6♦ 8♠ Q♣ 2♣ *
//******************
//Winner: Damir (HIGH_CARD) [A♣, Q♣, J♣, 8♠, 6♦]
class WinningCombinationDeterminer {

    fun determine(winCombinationsCandidates: Collection<List<Card>>): List<Card> {
        return winCombinationsCandidates.maxByOrNull { it.sumBy { card -> card.value.ordinal } }!!
    }
}