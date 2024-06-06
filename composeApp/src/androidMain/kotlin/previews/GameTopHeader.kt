package previews

import DarkColorPalette
import LightColorPalette
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ui.GameTopHeader


@Preview
@Composable
fun GameTopHeaderDark() {

    MaterialTheme(colors = DarkColorPalette) {
        GameTopHeader(text = "ABC", onClick = { println("click") })
    }
}

@Preview
@Composable
fun GameTopHeaderLight() {

    MaterialTheme(colors = LightColorPalette) {
        GameTopHeader(text = "ABC", onClick = { println("click") })
    }
}
