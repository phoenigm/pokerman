package ru.phoenigm.chpoker.service

import ru.phoenigm.chpoker.domain.CardDeck
import ru.phoenigm.chpoker.service.shuffle.DeckShuffleAlgorithm

class CardDeckShuffleMachine(
    private val shuffleAlgorithm: DeckShuffleAlgorithm
) {

    fun shuffle(cardDeck: CardDeck): CardDeck {
        return shuffleAlgorithm.shuffle(cardDeck)
    }
}