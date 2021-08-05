package ru.phoenigm.pokerman.core.rules

import ru.phoenigm.pokerman.core.domain.CardDeck
import ru.phoenigm.pokerman.core.rules.shuffle.DeckShuffleAlgorithm

class CardDeckShuffleMachine(
    private val shuffleAlgorithm: DeckShuffleAlgorithm
) {

    fun shuffle(cardDeck: CardDeck): CardDeck {
        return shuffleAlgorithm.shuffle(cardDeck)
    }
}