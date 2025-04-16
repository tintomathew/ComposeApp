import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.myapp.compose.ui.theme.ComposeAppTheme
import com.myapp.compose.ui.components.ScreenshotTestViewNew

class NewScreenshot {

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreviewNew() {
        ComposeAppTheme {
            ScreenshotTestViewNew()
        }
    }
}