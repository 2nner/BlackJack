package com.inner.blackjack.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager

val LocalColors = compositionLocalOf<BlackJackColors> {
    error("No colors provided!")
}

@Composable
fun BlackJackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: BlackJackColors = if (darkTheme) {
        BlackJackColors.defaultDarkColors()
    } else {
        BlackJackColors.defaultLightColors()
    },
    focusManager: FocusManager = LocalFocusManager.current,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalColors provides colors
    ) {
        Box(
            modifier = Modifier
                .background(colors.background)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            focusManager.clearFocus()
                        }
                    )
                }
        ) {
            content()
        }
    }
}

object BlackJackTheme {
    val colors: BlackJackColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
}