package ru.phoenigm.pokerman.core.rules.support

import org.junit.jupiter.api.Test

internal class CardExistenceMatrixTest {

    private val matrix: CardExistenceMatrix = CardExistenceMatrix()

    @Test
    fun testToString() {
        println(matrix)
    }
}