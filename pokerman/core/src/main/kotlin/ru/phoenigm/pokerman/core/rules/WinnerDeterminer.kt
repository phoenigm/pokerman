package ru.phoenigm.pokerman.core.rules

import ru.phoenigm.pokerman.core.domain.Combination
import ru.phoenigm.pokerman.core.domain.Player

class WinnerDeterminer {

    fun determine(candidates: List<Pair<Player, Combination>>): Pair<Player, Combination> {
        return candidates.maxByOrNull { it.second }!!
    }
}