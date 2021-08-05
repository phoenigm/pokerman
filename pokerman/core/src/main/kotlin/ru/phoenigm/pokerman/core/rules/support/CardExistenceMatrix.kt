package ru.phoenigm.pokerman.core.rules.support

import ru.phoenigm.pokerman.core.domain.CardSuit
import ru.phoenigm.pokerman.core.domain.CardValue

class CardExistenceMatrix {

    companion object {
        val ROWS = CardSuit.values().size
        val COLUMNS = CardValue.values().size + 1
    }

    private val cardExistenceMatrix = Array(ROWS) { Array(COLUMNS) { false } }

    fun fillCell(i: Int, j: Int) {
        cardExistenceMatrix[i][j] = true
    }

    fun get(i: Int, j: Int) = cardExistenceMatrix[i][j]

    fun firstCardSuitInColumn(column: Int): CardSuit {
        return (0 until ROWS)
            .map { it to cardExistenceMatrix[it][column] }
            .first { suit -> suit.second }
            .let { CardSuit.getByOrdinal(it.first) }
    }

    fun checkRow(rowNumber: Int, startIndex: Int, endIndex: Int): Boolean {
        return (startIndex..endIndex)
            .map { cardExistenceMatrix[rowNumber][it] }
            .reduce { result, cardExists -> result && cardExists }
    }

    fun checkRowIgnoreSuit(startIndex: Int, endIndex: Int): Boolean {
        return (startIndex..endIndex)
            .map { containsInColumn(it) }
            .reduce { result, cardExists -> result && cardExists }
    }

    private fun containsInColumn(column: Int): Boolean {
        return (0 until ROWS)
            .map { cardExistenceMatrix[it][column] }
            .reduce { result, cardExists -> result || cardExists }
    }

    override fun toString(): String {
        var matrix = "  A 2 3 4 5 6 7 8 9 T J Q K A \n"
        for (row in cardExistenceMatrix.withIndex()) {
            matrix += "${CardSuit.getByOrdinal(row.index)} "
            for (j in row.value) {
                matrix += if (j) "✔ " else "• "
            }
            matrix += "\n"
        }
        return matrix
    }
}