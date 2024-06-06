import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import data.Game
import data.Tile
import ui.GameTile

@Composable
fun MainGame(gridSize: Int, tileSize: Dp) {
    val game = remember { Game(gridSize, tileSize) }
    game.startGame()
    GameGrid(game.grid.gridTiles)
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
fun GameGrid(gridTiles: List<List<Tile>>) {
    val gridTiles2 = gridTiles.flatten()
    Surface(modifier = Modifier.padding(20.dp)) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier
                .border(BorderStroke(5.dp, Color.LightGray))
                .background(Color.LightGray),
            contentPadding = PaddingValues(5.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            itemsIndexed(gridTiles2) { index, item ->
                GameTile(
                    tile = item,
                    modifier = Modifier.aspectRatio(1f)
                )
            }
        }
    }
//    }
//    LazyColumn(modifier = Modifier.fillMaxSize()) {
//        items(gridTiles.size) { rowIndex ->
//            LazyRow(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ) {
//                items(gridTiles.size) { colIndex ->
//                    val gridTile = gridTiles[rowIndex][colIndex]
//                    GameTile(tile = gridTile, modifier = Modifier)
////                    GameTile(tile = gridTile, modifier = Modifier.fillParentMaxSize(1f))
//                }
//            }
//        }
//    }
//    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(3.dp)) {
////        for (column in 1..gridSize) {
////            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
////                for (row in 1..gridSize) {
////                    val gridTile = gridTiles.find {
////                        it.cell.row == row && it.cell.col == column
////                    }
////                    GameTile(tile = gridTile!!.tile, tileSize = tileSize)
////                }
////            }
////        }
//    }

//    LazyVerticalGrid(
//        columns = GridCells.Fixed(game.gridSize)
//    ) {
//        items(game.gridSize) {
//            GameTile(Tile(2), 100.dp)
//        }
//    }
}