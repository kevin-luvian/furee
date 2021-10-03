package com.example.furee.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

open class NavScreen(val route: String) {

    fun routeParams(vararg params: String): String = buildString {
        append(route)
        params.forEach { append("/$it") }
    }

    @Composable
    open fun View(navController: NavController) {
    }
}