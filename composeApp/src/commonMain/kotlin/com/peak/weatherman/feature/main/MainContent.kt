package com.peak.weatherman.feature.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.peak.weatherman.utils.composable.bar.WeathermanHeaderBar

@Composable
fun MainContent(
    state: MainState,
    onMenuClick: () -> Unit,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    with(state) {
        val pagerState = rememberPagerState(pageCount = { locations.size })

        HorizontalPager(
            state = pagerState,
            modifier = modifier.fillMaxSize()
        ) { page ->
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxSize()
            ) {
                WeathermanHeaderBar(
                    title = locations[page].timezone,
                    onMenuClick = onMenuClick,
                    onAddClick = onAddClick,
                )

                Text(text = "${locations[page].elevation} - elevation")
            }
        }
    }
}
