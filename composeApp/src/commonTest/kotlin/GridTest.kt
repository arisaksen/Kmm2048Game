import data.Direction
import data.Tile
import kotlin.test.Test
import kotlin.test.assertTrue

class GridTest {

    @Test
    fun `creating test grid with all numbers equal 2`() {
        val testGrid = recreateGrid(4, listOf(2))

        assertTrue { testGrid.isNotEmpty() }
        testGrid.onEach { assertTrue { it.num == 2 } }
    }

    /**
     * 2 2 2 2
     * 2 2 2 2
     * 2 2 2 2
     * 2 2 2 2
     * */
    @Test
    fun swipingRightShouldReturnExpectedGrid() {
        val testGrid = recreateGrid(4, listOf(2))
        testGrid.forEach {

        }


        assertTrue { testGrid.isNotEmpty() }
        testGrid.onEach { assertTrue { it.num == 2 } }
    }
    /**
     * 4 4 0 0
     * 4 4 0 0
     * 4 4 0 0
     * 4 4 0 0
     * */

}

fun Direction.gridSwipe(block: () -> Unit = {}) {
    when (this) {
        Direction.LEFT -> {
            block()
        }

        Direction.RIGHT -> TODO()
        Direction.UP -> TODO()
        Direction.DOWN -> TODO()
    }

}

