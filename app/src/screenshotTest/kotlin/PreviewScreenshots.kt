import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.myapp.compose.ui.theme.ComposeAppTheme
import com.myapp.compose.ui.theme.components.ScreenshotTestView

class PreviewScreenShots {
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ComposeAppTheme {
            ScreenshotTestView()
        }
    }
}