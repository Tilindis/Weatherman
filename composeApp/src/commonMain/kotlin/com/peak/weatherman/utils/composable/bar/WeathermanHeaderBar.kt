package com.peak.weatherman.utils.composable.bar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.peak.weatherman.utils.composable.button.WeathermanIconButton

@Composable
fun WeathermanHeaderBar(
    title: String,
    onMenuClick: () -> Unit,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        WeathermanIconButton(
            onClick = onMenuClick,
            imageVector = Icons.Default.Menu,
            modifier = Modifier.weight(1f),
        )

        Text(
            text = title,
            modifier = Modifier.weight(2f),
            textAlign = TextAlign.Center,
        )

        WeathermanIconButton(
            onClick = onAddClick,
            imageVector = Icons.Default.Add,
            modifier = Modifier.weight(1f),
        )
    }
}
