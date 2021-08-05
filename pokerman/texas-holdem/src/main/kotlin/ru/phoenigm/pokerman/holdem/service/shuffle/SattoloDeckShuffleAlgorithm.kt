package ru.phoenigm.pokerman.holdem.service.shuffle

import ru.phoenigm.pokerman.holdem.domain.CardDeck

class SattoloDeckShuffleAlgorithm : DeckShuffleAlgorithm {

    override fun shuffle(deck: CardDeck): CardDeck {
        return CardDeck(mutableListOf(*deck.cards.shuffled().toTypedArray()))
    }

}
