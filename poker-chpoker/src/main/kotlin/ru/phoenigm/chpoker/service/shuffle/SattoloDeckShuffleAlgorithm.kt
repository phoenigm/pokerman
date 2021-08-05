package ru.phoenigm.chpoker.service.shuffle

import ru.phoenigm.chpoker.domain.CardDeck

class SattoloDeckShuffleAlgorithm : DeckShuffleAlgorithm {

    override fun shuffle(deck: CardDeck): CardDeck {
        return CardDeck(mutableListOf(*deck.cards.shuffled().toTypedArray()))
    }

}
