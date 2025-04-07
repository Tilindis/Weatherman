package com.peak.weatherman.utils.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.peak.weatherman.feature.main.MainScreen
import com.peak.weatherman.feature.search.SearchScreen
import org.koin.compose.KoinContext

@Composable
fun NavHolder() {
    MaterialTheme {
        KoinContext {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screen.Main.route
                ) {
                    composable(Screen.Main.route) { MainScreen(navController) }
                    composable(Screen.Search.route) { SearchScreen(navController) }
                }
            }
        }
    }
}
