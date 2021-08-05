package ru.phoenigm.pokerman.holdem.service.shuffle

import ru.phoenigm.pokerman.holdem.domain.CardDeck

class FakeDeckShuffleAlgorithm : DeckShuffleAlgorithm {

    override fun shuffle(deck: CardDeck): CardDeck {
        return deck
    }

}
