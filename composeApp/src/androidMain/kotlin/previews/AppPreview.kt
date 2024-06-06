package previews

import App
import DarkColorPalette
import LightColorPalette
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun AppAndroidPreview() {
    MaterialTheme(colors = LightColorPalette) {
        App()
    }
}
