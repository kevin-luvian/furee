package com.example.furee.checkout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.furee.navigation.NavScreen

object CheckoutScreen : NavScreen("checkout") {
    @Composable
    fun View(navController: NavController, doctorName: String) {
        Box(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .verticalScroll(rememberScrollState())
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp),
                shape = RoundedCornerShape(15.dp),
                elevation = 5.dp
            ) {
                Column(
                    Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Checkout",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    Text(
                        text = "checkout an appointment with $doctorName",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.padding(vertical = 30.dp))
                    Button({ navController.popBackStack() }) {
                        Text("Go Back")
                    }
                }
            }
        }
    }
}