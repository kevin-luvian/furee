package com.example.furee.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp


@Composable
fun ImageRadioOption(
    modifier: Modifier = Modifier,
    title: String,
    painter: Painter? = null,
    selected: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    val color = if (selected) MaterialTheme.colors.primary else MaterialTheme.colors.background
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = selected,
            colors = RadioButtonDefaults.colors(
                MaterialTheme.colors.surface,
                MaterialTheme.colors.surface
            ),
            modifier = Modifier
                .border(5.dp, color, RoundedCornerShape(50)),
            onClick = { onClick?.invoke() }
        )
        Text(title,
            Modifier
                .weight(1f)
                .padding(horizontal = 10.dp))
        painter?.let { it ->
            Image(
                painter = it,
                contentDescription = "image of $title",
                contentScale = ContentScale.Fit,
                modifier = Modifier.height(20.dp)
            )
        }
    }
}