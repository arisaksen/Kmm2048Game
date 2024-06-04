package previews

import App
import DarkColorPalette
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ui.GameButton


@Preview
@Composable
fun GameButtonPreview() {
    MaterialTheme(colors = DarkColorPalette) {
        GameButton(text = "Test", onClick = {})
    }
}
