package org.geepawhill.plotter.game

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.plotter.game.Fact
import org.geepawhill.plotter.game.LocationMaker
import org.geepawhill.plotter.game.World
import org.junit.jupiter.api.Test

class LocationMakerTest {

    val world = World()

    @Test
    fun `makes the key if supplied to the maker`() {
        val maker = LocationMaker("site", "location")
        val location = maker.make(world)
        assertThat(location.key).isEqualTo("site.location")
    }

    @Test
    fun `uses next key if neither supplied nor set in lambda`() {
        Fact.reset()
        val maker = LocationMaker("site")
        val location = maker.make(world)
        assertThat(location.key).isEqualTo("site.Location-0")
    }

    @Test
    fun `uses key if set in lambda`() {
        val maker = LocationMaker("site")
        maker.key = "location"
        val location = maker.make(world)
        assertThat(location.key).isEqualTo("site.location")
    }

}