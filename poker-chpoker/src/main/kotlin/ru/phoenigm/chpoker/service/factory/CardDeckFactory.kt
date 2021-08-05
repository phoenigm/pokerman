package ru.phoenigm.chpoker.service.factory

import ru.phoenigm.chpoker.domain.Card
import ru.phoenigm.chpoker.domain.CardDeck
import ru.phoenigm.chpoker.domain.CardSuit
import ru.phoenigm.chpoker.domain.CardValue

class CardDeckFactory {

    fun createNewCardDeck(): CardDeck =
        CardValue.values().flatMap { cardValue ->
            CardSuit.values().map { cardSuit ->
                Card(cardValue, cardSuit)
            }
        }.let { CardDeck(mutableListOf(*it.toTypedArray())) }

}
