package org.geepawhill.plotter.game

data class Location(override val key: Key) : Fact {
    val actions = mutableListOf<Action>()
}