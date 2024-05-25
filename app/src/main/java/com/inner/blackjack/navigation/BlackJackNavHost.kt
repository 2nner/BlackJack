package com.inner.blackjack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.inner.blackjack.feature.home.HomeRoute

@Composable
fun BlackJackNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = "home")
    {
        composable("home") {
            HomeRoute()
        }
    }
}