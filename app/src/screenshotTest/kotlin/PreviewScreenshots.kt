import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.myapp.compose.ui.theme.ComposeAppTheme
import com.myapp.compose.ui.components.ScreenshotTestView
import com.myapp.compose.ui.components.ScreenshotTestViewNew

class PreviewScreenShots {
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ComposeAppTheme {
            ScreenshotTestView()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreviewNew() {
        ComposeAppTheme {
            ScreenshotTestViewNew()
        }
    }
}