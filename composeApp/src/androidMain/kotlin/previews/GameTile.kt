package previews

import DarkColorPalette
import LightColorPalette
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import data.Tile
import ui.GameTile

@Preview
@Composable
fun Tile0Dark() {
    MaterialTheme(colors = DarkColorPalette) {
        GameTile(
            tile = Tile(0),
            tileSize = 100.dp
        )
    }
}

@Preview
@Composable
fun Tile0Light() {
    MaterialTheme(colors = LightColorPalette) {
        GameTile(
            tile = Tile(0),
            tileSize = 100.dp
        )
    }
}

@Preview
@Composable
fun Tile2() {
    GameTile(
        tile = Tile(2),
        tileSize = 100.dp
    )
}

@Preview
@Composable
fun Tile32() {
    GameTile(
        tile = Tile(32),
        tileSize = 100.dp
    )
}

@Preview
@Composable
fun Tile128() {
    GameTile(
        tile = Tile(128),
        tileSize = 100.dp
    )
}
