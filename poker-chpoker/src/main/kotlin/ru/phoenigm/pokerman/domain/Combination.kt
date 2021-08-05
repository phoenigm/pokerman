package ru.phoenigm.pokerman.domain

data class Combination(
    val combinationCategory: CombinationCategory,
    val cards: List<Card>
) : Comparable<Combination> {

    override fun compareTo(other: Combination): Int {
        return if (this.combinationCategory.ordinal != other.combinationCategory.ordinal) {
            this.combinationCategory.ordinal - other.combinationCategory.ordinal
        } else {
            this.cards.sumBy { it.value.ordinal } - other.cards.sumBy { it.value.ordinal }
        }
    }
}
