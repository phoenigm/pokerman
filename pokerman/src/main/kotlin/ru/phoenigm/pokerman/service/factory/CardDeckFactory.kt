package ru.phoenigm.pokerman.service.factory

import ru.phoenigm.pokerman.domain.Card
import ru.phoenigm.pokerman.domain.CardDeck
import ru.phoenigm.pokerman.domain.CardSuit
import ru.phoenigm.pokerman.domain.CardValue

class CardDeckFactory {

    fun createNewCardDeck(): CardDeck =
        CardValue.values().flatMap { cardValue ->
            CardSuit.values().map { cardSuit ->
                Card(cardValue, cardSuit)
            }
        }.let { CardDeck(mutableListOf(*it.toTypedArray())) }

}
