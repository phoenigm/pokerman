package ru.phoenigm.chpoker.service.shuffle

import ru.phoenigm.chpoker.domain.CardDeck

class FakeDeckShuffleAlgorithm : DeckShuffleAlgorithm {

    override fun shuffle(deck: CardDeck): CardDeck {
        return deck
    }

}
