import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import co.touchlab.kermit.Logger
import ui.GameGrid
import ui.GameTopHeader


val DarkColorPalette = darkColors(primaryVariant = Color(0xff3f51b5))
val LightColorPalette = lightColors(primaryVariant = Color(0xff1da9da))

@Composable
fun App() {
    val gridTiles = remember { mutableStateOf(recreateGrid()) }
    val score = mutableStateOf(gridTiles.value.sumOf { it.num })
    val topScore = remember { mutableStateOf(gridTiles.value.sumOf { it.num }) }

    MaterialTheme(colors = if (isSystemInDarkTheme()) DarkColorPalette else LightColorPalette) {
        Surface(modifier = Modifier.fillMaxSize()
            .pointerInput(Unit) {
                detectSwipe(
                    onSwipeLeft = { Logger.i { "LEFT" } },
                    onSwipeRight = { Logger.i { "RIGHT" } },
                    onSwipeUp = { Logger.i { "UP" } },
                    onSwipeDown = { Logger.i { "DOWN" } },
                )
            }
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                GameTopHeader(
                    score = score.value,
                    topScore = topScore.value,
                    newGameClick = {
                        gridTiles.value = recreateGrid()
                        score.value = 0
                    },
                    gameUpdateSwipe = {
                        gridTiles.value.filter { it.num == 0 }.randomOrNull()
                            ?.let { it.num = listOf(2, 4).random() }
                        score.value = gridTiles.value.sumOf { it.num }
                        topScore.value =
                            if (score.value > topScore.value) score.value else topScore.value
                    }
                )
                GameGrid(modifier = Modifier, gridTiles.value)
            }
        }
    }

}
