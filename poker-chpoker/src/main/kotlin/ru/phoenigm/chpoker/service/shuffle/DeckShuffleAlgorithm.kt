package ru.phoenigm.chpoker.service.shuffle

import ru.phoenigm.chpoker.domain.CardDeck

interface DeckShuffleAlgorithm {

    fun shuffle(deck: CardDeck): CardDeck

}
