package work.niggergo.localchat.uicfg

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
  primary = Color(0xFFFFFFFF),
  secondary = Color(0xFF888888),
  tertiary = Color(0xFF404040),
  background = Color(0xFF000000),
  surface = Color(0xFF202020),
  outline = Color(0xFF888888)
)

private val LightColorScheme = lightColorScheme(
  primary = Color(0xFF000000),
  secondary = Color(0xFF888888),
  tertiary = Color(0xFFE0E0E0),
  background = Color(0xFFF8F8F8),
  surface = Color(0xFFFFFFFF),
  outline = Color(0xFF888888)
)

@Composable
fun LocalChatTheme(
  darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit
) {
  val colorScheme = when {
    darkTheme -> DarkColorScheme
    else -> LightColorScheme
  }
  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      val window = (view.context as Activity).window
      WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
    }
  }
  
  MaterialTheme(
    colorScheme = colorScheme, typography = Typography, content = content
  )
}