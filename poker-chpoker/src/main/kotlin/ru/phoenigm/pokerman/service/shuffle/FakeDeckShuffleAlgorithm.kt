package ru.phoenigm.pokerman.service.shuffle

import ru.phoenigm.pokerman.domain.CardDeck

class FakeDeckShuffleAlgorithm : DeckShuffleAlgorithm {

    override fun shuffle(deck: CardDeck): CardDeck {
        return deck
    }

}
