package ui

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable

@Composable
fun GameDialog(
    title: String,
    message: String,
    onConfirmListener: () -> Unit,
    onDismissListener: () -> Unit,
) {
    AlertDialog(
        title = { Text(text = title) },
        text = { Text(text = message) },
        confirmButton = { TextButton(onClick = { onConfirmListener.invoke() }) { Text("OK") } },
        dismissButton = { TextButton(onClick = { onDismissListener.invoke() }) { Text("Cancel") } },
        onDismissRequest = { onDismissListener.invoke() },
    )
}

enum class GameDialogText(val text: String) {
    GAME_OVER_TITLE("Game over"),
    GAME_OVER_MESSAGE("Want to start a new game?"),
    NEW_GAME_TITLE("Start a new game?"),
    NEW_GAME_MESSAGE("Starting a new game will erase your current game")
}