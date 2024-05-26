package com.inner.blackjack.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource

@Immutable
data class BlackJackColors(
    val background: Color,
    val black: Color,
) {

    companion object {
        @Composable
        fun defaultDarkColors(): BlackJackColors = BlackJackColors(
            background = colorResource(id = R.color.background_dark),
            black = colorResource(id = R.color.black_dark)
        )

        @Composable
        fun defaultLightColors(): BlackJackColors = BlackJackColors(
            background = colorResource(id = R.color.background),
            black = colorResource(id = R.color.black)
        )
    }
}