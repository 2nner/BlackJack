package com.inner.blackjack.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.inner.blackjack.navigation.BlackJackNavHost

@Composable
fun BlackJackMain() {
    val navController = rememberNavController()
    BlackJackNavHost(navHostController = navController)
}