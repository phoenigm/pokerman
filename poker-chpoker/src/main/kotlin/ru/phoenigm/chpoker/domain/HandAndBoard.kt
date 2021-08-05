package ru.phoenigm.chpoker.domain

data class HandAndBoard(
    val cards: List<Card>
) {
    companion object {
        private const val TEXAS_HOLDEM_HAND_AND_BOARD_CARDS_NUMBER = 7
    }

    init {
        assert(cards.size == TEXAS_HOLDEM_HAND_AND_BOARD_CARDS_NUMBER) {
            "Number of cards should equals $TEXAS_HOLDEM_HAND_AND_BOARD_CARDS_NUMBER. Current size ${cards.size}"
        }
    }
}
