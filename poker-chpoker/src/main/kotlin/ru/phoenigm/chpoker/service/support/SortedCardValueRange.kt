package ru.phoenigm.chpoker.service.support

import ru.phoenigm.chpoker.domain.CardValue

class SortedCardValueRange {

    companion object {
        private val range = arrayListOf(
            CardValue.ACE,
            CardValue.TWO,
            CardValue.THREE,
            CardValue.FOUR,
            CardValue.FIVE,
            CardValue.SIX,
            CardValue.SEVEN,
            CardValue.EIGHT,
            CardValue.NINE,
            CardValue.TEN,
            CardValue.JACK,
            CardValue.QUEEN,
            CardValue.KING,
            CardValue.ACE
        )

        fun get(index: Int) = range[index]
    }
}