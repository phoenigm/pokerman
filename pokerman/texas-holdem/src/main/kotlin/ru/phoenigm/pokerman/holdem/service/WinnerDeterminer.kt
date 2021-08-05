package ru.phoenigm.pokerman.holdem.service

import ru.phoenigm.pokerman.holdem.domain.Combination
import ru.phoenigm.pokerman.holdem.domain.Player

class WinnerDeterminer {

    fun determine(candidates: List<Pair<Player, Combination>>): Pair<Player, Combination> {
        return candidates.maxByOrNull { it.second }!!
    }
}