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
        GameTopHeader(100, 200)
    }
}

@Preview
@Composable
fun GameTopHeaderLight() {
    MaterialTheme(colors = LightColorPalette) {
        GameTopHeader(300, 400)
    }
}
