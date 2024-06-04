package data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.random.Random


enum class GameState {
    STOPPED, RUNNING
}

class Game(val gridSize: Int, val tileSize: Dp) {
    val grid = Grid(mutableStateListOf())
    var gameState by mutableStateOf(GameState.STOPPED)
    var gameStatus by mutableStateOf("Let's play!")
    var totalScore by mutableStateOf(0L)
    val startNumbers = listOf(0, 2, 4)


    fun startGame() {
        grid.gridTiles.clear()
        totalScore = 0L

        for (row in 1..gridSize) {
            for (column in 1..gridSize) {
                val randomStartNumber = startNumbers[Random.nextInt(startNumbers.size)]
                grid.gridTiles.add(
                    GridTile(
                        cell = Cell(row, column),
                        tile = Tile(randomStartNumber)
                    )
                )
            }
        }

        gameState = GameState.RUNNING
        gameStatus = "Good luck!"
    }

    fun update(time: Long) {
//        val delta = time - prevTime
//        val floatDelta = (delta / 1E8).toFloat()
//        prevTime = time
//
//        if (gameState == GameState.STOPPED) return
//
//        for (gameObject in gameObjects) {
//            gameObject.update(floatDelta, this)
//        }
//
//        val allDisabled = gameObjects.filterIsInstance<Tile>().all {
////            !it.isEnabled
//            false
//        }
//
//        if (allDisabled && gameState == GameState.RUNNING) {
//            winGame()
//        }
//
//        totalScore += delta
    }

    fun endGame() {
        grid.gridTiles.clear()
        gameState = GameState.STOPPED
        gameStatus = "Better luck next time!"
    }

    fun winGame() {
        gameState = GameState.STOPPED
        gameStatus = "Congratulations!"
    }

    var width by mutableStateOf(0.dp)
    var height by mutableStateOf(0.dp)
}