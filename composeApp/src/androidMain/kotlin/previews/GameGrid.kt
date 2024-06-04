package previews

import DarkColorPalette
import GameGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import data.Cell
import data.GridTile
import data.Tile


@Preview
@Composable
fun GameGridDark() {
    val gridSize = 4
    val gridTiles = mutableListOf<GridTile>().apply {
        for (col in 1..gridSize) {
            for (row in 1..gridSize) {
                val randomTileNumber =
                    listOf(0, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048).random()
                add(GridTile(Cell(row, col), Tile(randomTileNumber)))
            }
        }
    }
    val tileSize = 70.dp

    MaterialTheme(colors = DarkColorPalette) {
        GameGrid(gridSize, gridTiles, tileSize)
    }
}
