import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.Cell
import data.Tile
import ui.GameButton
import ui.GameTopHeader


val DarkColorPalette = darkColors(primaryVariant = Color(0xff3f51b5))
val LightColorPalette = lightColors(primaryVariant = Color(0xff1da9da))

@Composable
fun App() {
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

    MaterialTheme(colors = if (isSystemInDarkTheme()) DarkColorPalette else LightColorPalette) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                GameTopHeader(text = "test", onClick = {})
                Text(
                    text = "Join the numbers and get to the 2048 tile!",
                    style = MaterialTheme.typography.h6,
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold
                )
                GameGrid(gridTiles)
            }
        }
    }
}
