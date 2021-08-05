package ru.phoenigm.pokerman.core.rules.shuffle

import ru.phoenigm.pokerman.core.domain.CardDeck

class SattoloDeckShuffleAlgorithm : DeckShuffleAlgorithm {

    override fun shuffle(deck: CardDeck): CardDeck {
        return CardDeck(mutableListOf(*deck.cards.shuffled().toTypedArray()))
    }

}
