package ru.phoenigm.chpoker.service.support

import org.junit.jupiter.api.Test
import ru.phoenigm.chpoker.service.support.CardExistenceMatrix

internal class CardExistenceMatrixTest {

    private val matrix: CardExistenceMatrix = CardExistenceMatrix()

    @Test
    fun testToString() {
        println(matrix)
    }
}