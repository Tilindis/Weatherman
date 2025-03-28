package com.peak.weatherman.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peak.weatherman.utils.domain.Weather
import com.peak.weatherman.utils.repository.CheckRepo
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val cr: CheckRepo
) : ViewModel() {
    fun getWeathermanData(): List<Weather> {
        return cr.getWeathermanData()
    }

    fun insertWeathermanData() {
        val data = listOf(
            Weather(
                cityId = "123",
                time = "123",
                interval = "123",
                temperature = "123",
                windspeed = "123",
                winddirection = "123",
                is_day = "123",
                weathercode = "123"
            ),
            Weather(
                cityId = "321",
                time = "123",
                interval = "123",
                temperature = "123",
                windspeed = "123",
                winddirection = "123",
                is_day = "123",
                weathercode = "123"
            ),
            Weather(
                cityId = "333",
                time = "123",
                interval = "123",
                temperature = "123",
                windspeed = "123",
                winddirection = "123",
                is_day = "123",
                weathercode = "123"
            ),
        )

        cr.insertWeathermanData(data)
    }

    fun removeAllWeathermanData() {
        cr.removeAllWeathermanData()
    }

    fun collectData() {
        viewModelScope.launch {
            cr.getWeather()
        }
    }
}
