package ru.phoenigm.pokerman.holdem.domain

data class CardDeck(
    val cards: MutableList<Card>
) {
    companion object {
        private const val CARD_DECK_SIZE = 52
    }

    init {
        assert(cards.size == CARD_DECK_SIZE) {
            "Number of cards in deck should equals $CARD_DECK_SIZE, but equals ${cards.size}"
        }
    }
}