package ru.phoenigm.pokerman.holdem.service.factory

import ru.phoenigm.pokerman.holdem.domain.Card
import ru.phoenigm.pokerman.holdem.domain.CardDeck
import ru.phoenigm.pokerman.holdem.domain.CardSuit
import ru.phoenigm.pokerman.holdem.domain.CardValue

class CardDeckFactory {

    fun createNewCardDeck(): CardDeck =
        CardValue.values().flatMap { cardValue ->
            CardSuit.values().map { cardSuit ->
                Card(cardValue, cardSuit)
            }
        }.let { CardDeck(mutableListOf(*it.toTypedArray())) }

}
