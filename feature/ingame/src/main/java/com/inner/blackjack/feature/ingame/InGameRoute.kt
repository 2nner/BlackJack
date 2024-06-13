package com.inner.blackjack.feature.ingame

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

@Composable
fun InGameRoute(
    viewModel: InGameViewModel = hiltViewModel(),
    roomCode: Int,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
) {
    InGameScreen(roomCode = roomCode)

    DisposableEffect(Unit) {
        val observer = LifecycleEventObserver { lifecycleOwner, event ->
            when (event) {
                Lifecycle.Event.ON_DESTROY -> {
                    viewModel.exitGame()
                }
                else -> { /* Do nothing */ }
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            viewModel.exitGame()
        }
    }
}

@Composable
fun InGameScreen(
    roomCode: Int = 1234,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "In Game $roomCode")
    }
}