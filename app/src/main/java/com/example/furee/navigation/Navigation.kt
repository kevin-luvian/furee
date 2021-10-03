package com.example.furee.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.furee.appointment.AppointmentScreen
import com.example.furee.checkout.CheckoutScreen
import com.example.furee.promo.PromoScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppointmentScreen.route) {
        composable(AppointmentScreen.route) {
            AppointmentScreen.View(navController)
        }
        composable(PromoScreen.route) {
            PromoScreen.View(navController)
        }
        composable(
            CheckoutScreen.routeParams("{doctorName}"),
            arguments = listOf(
                navArgument("doctorName") { type = NavType.StringType }
            )
        ) {
            CheckoutScreen.View(
                navController,
                it.arguments?.getString("doctorName") ?: "undefined"
            )
        }
    }
}