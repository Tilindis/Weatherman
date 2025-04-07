package com.peak.weatherman.utils.mapper

import com.peak.weatherman.utils.entity.CurrentWeatherEntity
import com.peak.weatherman.utils.entity.HourlyEntity
import com.peak.weatherman.utils.entity.LocationEntity
import com.peak.weatherman.utils.response.CurrentWeather
import com.peak.weatherman.utils.response.CurrentWeatherUnits
import com.peak.weatherman.utils.response.HourlyUnits
import com.peak.weatherman.utils.response.WeatherResponse

fun toHourlyEntity(
    timezone: String?,
    time: String?,
    temperatureTwoMeters: Double?,
    windDirectionTenMeters: Int?,
    hourlyUnits: HourlyUnits?,
): HourlyEntity {
    return HourlyEntity(
        timezone = timezone ?: "",
        time = time ?: "",
        timeUnit = hourlyUnits?.time ?: "",
        temperatureTwoMeters = temperatureTwoMeters ?: 0.0,
        temperatureTwoMetersUnit = hourlyUnits?.temperature_2m ?: "",
        windDirectionTenMeters = windDirectionTenMeters ?: 0,
        windDirectionTenMetersUnit = hourlyUnits?.winddirection_10m ?: "",
    )
}

fun toWeatherEntity(
    timezone: String?,
    currentWeather: CurrentWeather?,
    currentWeatherUnits: CurrentWeatherUnits?
): CurrentWeatherEntity {
    return CurrentWeatherEntity(
        timezone = timezone ?: "",
        time = currentWeather?.time ?: "",
        timeUnit = currentWeatherUnits?.time ?: "",
        interval = currentWeather?.interval ?: 0,
        intervalUnit = currentWeatherUnits?.interval ?: "",
        temperature = currentWeather?.temperature ?: 0.0,
        temperatureUnit = currentWeatherUnits?.temperature ?: "",
        windSpeed = currentWeather?.windspeed ?: 0.0,
        windSpeedUnit = currentWeatherUnits?.windspeed ?: "",
        windDirection = currentWeather?.winddirection ?: 0,
        windDirectionUnit = currentWeatherUnits?.winddirection ?: "",
        isDay = currentWeather?.is_day ?: 0,
        isDayUnit = currentWeatherUnits?.is_day ?: "",
        weatherCode = currentWeather?.weathercode ?: 0,
        weatherCodeUnit = currentWeatherUnits?.weathercode ?: "",
    )
}

fun WeatherResponse.toLocationEntity() = LocationEntity(
    timezone = timezone ?: "",
    latitude = latitude ?: 0.0,
    longitude = longitude ?: 0.0,
    generationTimeMs = generationtime_ms ?: 0.0,
    utcOffsetSeconds = utc_offset_seconds ?: 0L,
    timezoneAbbreviation = timezone_abbreviation ?: "",
    elevation = elevation ?: 0.0,
)
