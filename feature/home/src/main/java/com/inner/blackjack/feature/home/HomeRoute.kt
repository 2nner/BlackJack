package com.inner.blackjack.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.inner.blackjack.designsystem.BlackJackTheme
import com.inner.blackjack.designsystem.R

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val vmEvent by viewModel.event.collectAsState(initial = HomeViewModel.Event.Idle)

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    ) { _ ->
        HomeScreen(
            onCreateRoomButtonClick = viewModel::createRoom,
            onEnterRoomButtonClick = viewModel::enterRoom,
        )
    }

    LaunchedEffect(key1 = vmEvent) {
        when (val event = vmEvent) {
            is HomeViewModel.Event.ShowSnackbar -> {
                snackbarHostState.showSnackbar(
                    message = event.message
                )
            }
            is HomeViewModel.Event.NavigateToGame -> {
                // TODO
            }
            else -> { /** do nothing */ }
        }
    }
}

@Composable
fun HomeScreen(
    onCreateRoomButtonClick: () -> Unit,
    onEnterRoomButtonClick: (Int) -> Unit,
) {
    var homeRoomCode by remember { mutableStateOf("") }

    BlackJackTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.blackJack),
                color = BlackJackTheme.colors.black,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(80.dp))

            OutlinedTextField(
                value = homeRoomCode,
                onValueChange = { homeRoomCode = it },
                label = {
                    Text(text = stringResource(id = R.string.homeRoomCodeLabelTitle))
                }
            )

            Spacer(modifier = Modifier.height(80.dp))

            FilledTonalButton(
                onClick = {
                    onCreateRoomButtonClick()
                },
            ) {
                Text(
                    text = stringResource(id = R.string.homeCreateRoomButtonTitle),
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            FilledTonalButton(
                onClick = {
                    onEnterRoomButtonClick(homeRoomCode.toInt())
                },
            ) {
                Text(
                    text = stringResource(id = R.string.homeEnterButtonTitle),
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
fun HomePreview() {
    BlackJackTheme {
        HomeScreen(
            onCreateRoomButtonClick = {},
            onEnterRoomButtonClick = {},
        )
    }
}