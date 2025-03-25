package com.peak.weatherman

import androidx.compose.ui.window.ComposeUIViewController
import com.peak.weatherman.utils.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }
