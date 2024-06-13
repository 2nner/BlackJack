package com.inner.blackjack.feature.ingame.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.inner.blackjack.feature.ingame.InGameRoute

const val IN_GAME_ARG_ROOM_CODE = "roomCode"
const val IN_GAME_ROUTE = "inGame/{$IN_GAME_ARG_ROOM_CODE}"

fun NavController.navigateInGame(
    roomCode: Int
) {
    this.navigate(
        IN_GAME_ROUTE.replace("{${IN_GAME_ARG_ROOM_CODE}}", roomCode.toString())
    )
}

fun NavGraphBuilder.inGameScreen() {
    composable(
        route = IN_GAME_ROUTE,
        arguments = listOf(
            navArgument(name = IN_GAME_ARG_ROOM_CODE) {
                type = NavType.IntType
            }
        )
    ) { navBackStackEntry ->
        InGameRoute(
            roomCode = navBackStackEntry.arguments?.getInt(IN_GAME_ARG_ROOM_CODE) ?: -1
        )
    }
}