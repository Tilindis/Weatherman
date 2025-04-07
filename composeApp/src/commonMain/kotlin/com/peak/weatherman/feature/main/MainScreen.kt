package com.peak.weatherman.feature.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.peak.weatherman.feature.search.SearchScreen
import com.peak.weatherman.utils.navigation.Screen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreen(
    navController: NavController
) {
    val viewModel = koinViewModel<MainViewModel>()
    val state = viewModel.state.collectAsState().value

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        MainContent(
            state = state,
            onMenuClick = { },
            onAddClick = { navigateTo(navController, Screen.Search.route) }
        )
    }
}

private fun navigateTo(
    navController: NavController,
    route: String,
) {
    navController.navigate(route)
}
