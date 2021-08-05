package ru.phoenigm.pokerman.service

import ru.phoenigm.pokerman.domain.Combination
import ru.phoenigm.pokerman.domain.Player

class WinnerDeterminer {

    fun determine(candidates: List<Pair<Player, Combination>>): Pair<Player, Combination> {
        return candidates.maxByOrNull { it.second }!!
    }
}