import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import data.Game
import data.GridTile
import data.Tile
import ui.GameTile

@Composable
fun MainGame(gridSize: Int, tileSize: Dp) {
    val game = remember { Game(gridSize, tileSize) }
    game.startGame()
    GameGrid(gridSize, game.grid.gridTiles, tileSize)
//    game.drawGame()
//    val density = LocalDensity.current
//    LaunchedEffect(Unit) {
//        while (true) {
//            withFrameNanos {
//                game.update(it)
//                game.drawGame()
//            }
//        }
//    }
}

@Composable
fun GameGrid(gridSize: Int, gridTiles: List<GridTile>, tileSize: Dp) {
    Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
        for (column in 1..gridSize) {
            Row(horizontalArrangement = Arrangement.spacedBy(3.dp)) {
                for (row in 1..gridSize) {
                    val gridTile = gridTiles.find {
                        it.cell.row == row && it.cell.col == column
                    }
                    GameTile(tile = gridTile!!.tile, tileSize = tileSize)
                }
            }
        }
    }

//    LazyVerticalGrid(
//        columns = GridCells.Fixed(game.gridSize)
//    ) {
//        items(game.gridSize) {
//            GameTile(Tile(2), 100.dp)
//        }
//    }
}