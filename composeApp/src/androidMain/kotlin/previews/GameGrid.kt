package previews

import DarkColorPalette
import GameGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import data.Tile


@Preview
@Composable
fun GameGridDark() {
    val gridSize = 4
    val gridTiles = mutableListOf<List<Tile>>()
    for (col in 1..gridSize) {
        val rowTiles = mutableListOf<Tile>()
        for (row in 1..gridSize) {
            val randomTileNumber =
                listOf(0, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048).random()
            rowTiles.add(Tile(randomTileNumber))
        }
        gridTiles.add(rowTiles)
    }

    MaterialTheme(colors = DarkColorPalette) {
        GameGrid(gridTiles)
    }
}
