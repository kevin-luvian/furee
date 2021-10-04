package com.example.furee.promo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.furee.navigation.NavScreen
import com.example.furee.ui.component.ScreenSurface

object PromoScreen : NavScreen("promo") {

    @Composable
    override fun View(navController: NavController) {
        ScreenSurface {
            Column(
                Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Promo",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(vertical = 30.dp))
                Button({ navController.popBackStack() }) {
                    Text("Go Back")
                }
            }
        }
    }
}