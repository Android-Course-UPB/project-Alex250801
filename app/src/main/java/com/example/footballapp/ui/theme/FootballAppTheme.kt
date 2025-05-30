package com.example.footballapp.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF0066CC),
    onPrimary = Color.White,
    secondary = Color(0xFF0099FF),
    onSecondary = Color.White,
    background = Color(0xFFF2F2F2),
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF3399FF),
    onPrimary = Color.Black,
    secondary = Color(0xFF66BBFF),
    onSecondary = Color.Black,
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF1E1E1E),
    onSurface = Color.White,
)

@Composable
fun FootballAppTheme(
    darkTheme: Boolean = false,  // You can add system theme detection later
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography(),
        content = content
    )
}
