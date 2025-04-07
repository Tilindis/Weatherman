package com.peak.weatherman.utils.composable.button

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun WeathermanIconButton(
    onClick: () -> Unit,
    imageVector: ImageVector,
    modifier: Modifier,
) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
        content = {
            Icon(
                imageVector = imageVector,
                contentDescription = "weathermanIcon button icon"
            )
        }
    )
}
