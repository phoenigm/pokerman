package ru.phoenigm.pokerman.service.shuffle

import ru.phoenigm.pokerman.domain.CardDeck

class SattoloDeckShuffleAlgorithm : DeckShuffleAlgorithm {

    override fun shuffle(deck: CardDeck): CardDeck {
        return CardDeck(mutableListOf(*deck.cards.shuffled().toTypedArray()))
    }

}
