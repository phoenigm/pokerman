package ru.phoenigm.pokerman.core.rules.shuffle

import ru.phoenigm.pokerman.core.domain.CardDeck

class FakeDeckShuffleAlgorithm : DeckShuffleAlgorithm {

    override fun shuffle(deck: CardDeck): CardDeck {
        return deck
    }

}
