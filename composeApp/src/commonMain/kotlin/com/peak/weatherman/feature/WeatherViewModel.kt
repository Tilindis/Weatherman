package com.peak.weatherman.feature

import androidx.lifecycle.ViewModel
import com.peak.weatherman.utils.repository.CheckRepo

class WeatherViewModel(
    private val cr: CheckRepo
) : ViewModel() {
    fun getText(): String {
        return cr.getText()
    }
}
