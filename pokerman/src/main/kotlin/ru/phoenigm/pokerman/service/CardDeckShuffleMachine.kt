package ru.phoenigm.pokerman.service

import ru.phoenigm.pokerman.domain.CardDeck
import ru.phoenigm.pokerman.service.shuffle.DeckShuffleAlgorithm

class CardDeckShuffleMachine(
    private val shuffleAlgorithm: DeckShuffleAlgorithm
) {

    fun shuffle(cardDeck: CardDeck): CardDeck {
        return shuffleAlgorithm.shuffle(cardDeck)
    }
}