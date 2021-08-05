package ru.phoenigm.chpoker.domain

import java.time.OffsetDateTime

data class CardDealing(
    val startedAt: OffsetDateTime,
    val endedAt: OffsetDateTime,
    val dealing: Map<Player, Hand>
)