package ru.phoenigm.pokerman.core.rules.factory

import ru.phoenigm.pokerman.core.domain.Card
import ru.phoenigm.pokerman.core.domain.CardDeck
import ru.phoenigm.pokerman.core.domain.CardSuit
import ru.phoenigm.pokerman.core.domain.CardValue

class CardDeckFactory {

    fun createNewCardDeck(): CardDeck =
        CardValue.values().flatMap { cardValue ->
            CardSuit.values().map { cardSuit ->
                Card(cardValue, cardSuit)
            }
        }.let { CardDeck(mutableListOf(*it.toTypedArray())) }

}
