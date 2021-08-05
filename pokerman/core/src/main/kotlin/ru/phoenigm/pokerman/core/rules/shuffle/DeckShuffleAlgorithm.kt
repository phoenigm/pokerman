package ru.phoenigm.pokerman.core.rules.shuffle

import ru.phoenigm.pokerman.core.domain.CardDeck

interface DeckShuffleAlgorithm {

    fun shuffle(deck: CardDeck): CardDeck

}
