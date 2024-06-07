package previews

import App
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun AppAndroidPreview() {
    App()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AppAndroidPreviewDark() {
    App()
}
