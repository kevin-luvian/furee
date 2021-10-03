package com.example.furee.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.furee.ui.theme.DarkGray

@Composable
fun BillView(modifier: Modifier = Modifier, title: String, cost: Float, description: String = "") {
    Column(modifier) {
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            Text(title, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Text(String.format("$%.2f", cost), fontWeight = FontWeight.Bold, fontSize = 15.sp)
        }

        if (description.isNotEmpty())
            Text(description, color = DarkGray.copy(.7f), fontSize = 12.sp)
    }
}