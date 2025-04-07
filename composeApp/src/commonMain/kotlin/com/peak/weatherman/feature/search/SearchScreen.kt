package com.peak.weatherman.feature.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.peak.weatherman.utils.navigation.Screen
import com.peak.weatherman.utils.response.CitySuggestion
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SearchScreen(
    navController: NavController,
) {
    val viewModel = koinViewModel<SearchViewModel>()
    val state = viewModel.state.collectAsState().value

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Add new location",
                    modifier = Modifier.weight(2f),
                    textAlign = TextAlign.Center,
                )

                TextButton(
                    onClick = { popBackStack(navController) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Cancel")
                }
            }
        }

        item {
            SearchBar(
                query = state.cityName,
                onQueryChange = viewModel::updateCityName,
                onClearQuery = viewModel::clearCityName,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .padding(4.dp)
            )
        }

        items(state.cities) { city ->
            CityItem(city) {
                viewModel.loadWeather(it.first, it.second)
                navigateTo(navController, Screen.Main.route)
            }
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChange: (String) -> Unit,
    onClearQuery: () -> Unit,
    hint: String = "Search cities...",
) {
    Box(modifier = modifier) {
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search icon"
                )
            },
            trailingIcon = {
                if (query.isNotEmpty()) {
                    IconButton(onClick = onClearQuery) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Clear search"
                        )
                    }
                }
            },
            placeholder = {
                Text(text = hint)
            },
            singleLine = true,
            shape = RoundedCornerShape(16.dp)
        )
    }
}

@Composable
fun CityItem(
    city: CitySuggestion,
    onClick: (Pair<Double, Double>) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(Pair(city.lat ?: 0.0, city.lon ?: 0.0)) },
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = city.name ?: "")
        Text(text = city.country ?: "")
    }
}

private fun navigateTo(
    navController: NavController,
    route: String,
) {
    navController.navigate(route)
}

private fun popBackStack(
    navController: NavController,
) {
    navController.popBackStack()
}