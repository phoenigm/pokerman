package ru.phoenigm.pokerman.service.shuffle

import ru.phoenigm.pokerman.domain.CardDeck

interface DeckShuffleAlgorithm {

    fun shuffle(deck: CardDeck): CardDeck

}
