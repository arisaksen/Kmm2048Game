package data

import androidx.compose.ui.graphics.Color

data class Tile(val num: Int, val id: Int) {
    constructor(num: Int) : this(num, tileIdCounter++)
    operator fun times(operand: Int): Tile = Tile(num * operand)

    companion object {
        // We assign each tile a unique ID and use it to efficiently
        // animate tile objects within the compose UI.
        private var tileIdCounter = 0
    }
}

enum class Direction { NORTH, SOUTH, EAST, WEST }

