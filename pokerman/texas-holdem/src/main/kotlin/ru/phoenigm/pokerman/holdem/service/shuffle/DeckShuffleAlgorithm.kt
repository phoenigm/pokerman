package ru.phoenigm.pokerman.holdem.service.shuffle

import ru.phoenigm.pokerman.holdem.domain.CardDeck

interface DeckShuffleAlgorithm {

    fun shuffle(deck: CardDeck): CardDeck

}
