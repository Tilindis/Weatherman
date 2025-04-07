package com.peak.weatherman.feature.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peak.weatherman.utils.repository.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: MainRepository
): ViewModel() {
    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            mainRepository.getLocations().collect { locations ->
                _state.update { it.copy(locations = locations) }
            }
        }
    }
}
