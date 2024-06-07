package previews

import DarkColorPalette
import LightColorPalette
import android.content.res.Configuration
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import data.Tile
import ui.GameGrid


@Preview
@Composable
fun GameGridLight() {
    MaterialTheme(colors = LightColorPalette) {
        GameGrid(gridTiles = customGrid())
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GameGridDark() {
    MaterialTheme(colors = DarkColorPalette) {
        GameGrid(gridTiles = customGrid())
    }
}

fun customGrid(gridSize: Int = 4): MutableList<Tile> {
    val gridTiles = mutableListOf<Tile>()
    for (col in 1..gridSize) {
        for (row in 1..gridSize) {
            val randomTileNumber =
                listOf(0, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048).random()
            gridTiles.add(Tile(randomTileNumber))
        }
    }

    return gridTiles
}
