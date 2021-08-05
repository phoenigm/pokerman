package ru.phoenigm.chpoker.service

import ru.phoenigm.chpoker.domain.Combination
import ru.phoenigm.chpoker.domain.Player

class WinnerDeterminer {

    fun determine(candidates: List<Pair<Player, Combination>>): Pair<Player, Combination> {
        return candidates.maxByOrNull { it.second }!!
    }
}