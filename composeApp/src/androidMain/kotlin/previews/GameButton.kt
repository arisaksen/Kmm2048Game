package previews

import DarkColorPalette
import android.content.res.Configuration
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

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GameButtonPreviewDark() {
    GameButton(text = "Test", onClick = {})
}
