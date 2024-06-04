import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.Cell
import data.GridTile
import data.Tile
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.GameButton


val DarkColorPalette = darkColors(primaryVariant = Color(0xff3f51b5))
val LightColorPalette = lightColors(primaryVariant = Color(0xff1da9da))

@Composable
fun App() {
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

    MaterialTheme(colors = if (isSystemInDarkTheme()) DarkColorPalette else LightColorPalette) {
        Column(modifier = Modifier.background(color = DarkColorPalette.background)) {
            Box(modifier = Modifier.fillMaxWidth().height(100.dp).background(DarkColorPalette.background)) {
                Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = "2048", fontSize = 60.sp, color = Color.LightGray)
                    Card {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Score", fontSize = 30.sp)
                            Text(text = "123", fontSize = 10.sp)
                        }
                    }
                    Card {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Best", fontSize = 30.sp)
                            Text(text = "666", fontSize = 10.sp)
                        }
                    }
                    GameButton(text = "New Game", onClick = {})
                }
            }
            GameGrid(gridSize, gridTiles, tileSize)
        }
    }
}
