package com.inner.blackjack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigation
import com.inner.blackjack.feature.home.navigation.HOME_ROUTE
import com.inner.blackjack.feature.home.navigation.homeScreen
import com.inner.blackjack.feature.ingame.navigation.inGameScreen
import com.inner.blackjack.feature.ingame.navigation.navigateInGame

@Composable
fun BlackJackNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
    ) {
        homeScreen(
            navigateToInGame = navController::navigateInGame
        )
        inGameScreen()
    }
}