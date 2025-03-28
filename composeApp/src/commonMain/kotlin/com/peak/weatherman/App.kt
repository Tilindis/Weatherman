package com.peak.weatherman

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.peak.weatherman.feature.search.SearchScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            NavHost(
                navController = rememberNavController(),
                startDestination = "home"
            ) {
                composable(route = "home") {
                    SearchScreen()
//                    val viewModel = koinViewModel<WeatherViewModel>()
//                    var showContent by remember { mutableStateOf(false) }
//                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                        Button(onClick = { showContent = !showContent }) {
//                            Text("Click me!")
//                        }
//                        AnimatedVisibility(showContent) {
//                            // viewModel.insertWeathermanData()
//                            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                                Image(painterResource(Res.drawable.compose_multiplatform), null)
//                                viewModel.collectData()
//                                Text("Compose: ${viewModel.getWeathermanData()}")
//                            }
//                        }
//                    }
                }
            }
        }
    }
}