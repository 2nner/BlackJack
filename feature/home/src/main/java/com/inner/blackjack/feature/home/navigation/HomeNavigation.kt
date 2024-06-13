package com.inner.blackjack.feature.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.inner.blackjack.feature.home.HomeRoute

const val HOME_ROUTE = "home"

fun NavGraphBuilder.homeScreen(
    navigateToInGame: (Int) -> Unit,
) {
    composable(
        route = HOME_ROUTE
    ) {
        HomeRoute(
            navigateToInGame = navigateToInGame
        )
    }
}