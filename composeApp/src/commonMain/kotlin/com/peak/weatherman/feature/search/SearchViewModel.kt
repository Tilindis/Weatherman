package com.peak.weatherman.feature.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peak.weatherman.utils.repository.SearchRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchRepository: SearchRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(SearchState())
    val state = _state.asStateFlow()

    private fun searchCities(query: String) {
        viewModelScope.launch {
            searchRepository.searchCities(query).collect {
                _state.update { state -> state.copy(cities = it) }
            }
        }
    }

    fun loadWeather(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            searchRepository.loadWeather(latitude, longitude)
        }
    }

    fun updateCityName(value: String) {
        _state.update { it.copy(cityName = value) }
        searchCities(value)
    }

    fun clearCityName() {
        _state.update { it.copy(cityName = "") }
        searchCities("")
    }
}
