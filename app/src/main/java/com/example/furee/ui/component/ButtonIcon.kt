package com.example.furee.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ButtonIcon(imageVector: ImageVector, modifier: Modifier = Modifier) {
    OutlinedButton(
        {},
        contentPadding = PaddingValues(0.dp),
        modifier = modifier.size(42.dp),
        shape = RoundedCornerShape(35),
        border = BorderStroke(1.dp, MaterialTheme.colors.background),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = MaterialTheme.colors.surface,
            contentColor = MaterialTheme.colors.primary
        )
    ) {
        Icon(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            imageVector = imageVector,
            contentDescription = "Localized description"
        )
    }
}