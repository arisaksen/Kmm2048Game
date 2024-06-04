package previews

import DarkColorPalette
import LightColorPalette
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ui.GameDialog
import ui.GameDialogText


@Preview
@Composable
fun NewGameDialogDark() {
    MaterialTheme(colors = DarkColorPalette) {
        GameDialog(
            title = GameDialogText.NEW_GAME_TITLE.text,
            message = GameDialogText.NEW_GAME_MESSAGE.text,
            {},
            {}
        )
    }
}

@Preview
@Composable
fun NewGameDialogLight() {
    MaterialTheme(colors = LightColorPalette) {
        GameDialog(
            title = GameDialogText.NEW_GAME_TITLE.text,
            message = GameDialogText.NEW_GAME_MESSAGE.text,
            {},
            {}
        )
    }
}

@Preview
@Composable
fun GameOverDialogDark() {
    MaterialTheme(colors = DarkColorPalette) {
        GameDialog(
            title = GameDialogText.GAME_OVER_TITLE.text,
            message = GameDialogText.GAME_OVER_MESSAGE.text,
            {},
            {}
        )
    }
}

@Preview
@Composable
fun GameOverDialogLight() {
    MaterialTheme(colors = LightColorPalette) {
        GameDialog(
            title = GameDialogText.GAME_OVER_TITLE.text,
            message = GameDialogText.GAME_OVER_MESSAGE.text,
            {},
            {}
        )
    }
}
