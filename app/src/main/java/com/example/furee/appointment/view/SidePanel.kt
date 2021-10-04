package com.example.furee.appointment.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.furee.checkout.CheckoutScreen
import com.example.furee.promo.PromoScreen
import kotlinx.coroutines.launch

@Composable
fun SidePanel(navController: NavController, content: @Composable (ScaffoldState) -> Unit) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = { SidePanelDrawer(navController, scaffoldState) }) {
        content(scaffoldState)
    }
}

@Composable
fun SidePanelDrawer(navController: NavController, scaffoldState: ScaffoldState) {
    val scope = rememberCoroutineScope()
    Column {
        Box(
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primary)
        ) {
            Text(
                "FUREE",
                color = MaterialTheme.colors.onPrimary,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp, 30.dp),
            )
        }
        SidePanelButton("to promo screen") {
            navController.navigate(PromoScreen.route)
            scope.launch { scaffoldState.drawerState.close() }
        }
        SidePanelButton("to checkout screen") {
            navController.navigate(CheckoutScreen.routeParams("none"))
            scope.launch { scaffoldState.drawerState.close() }
        }
    }
}

@Composable
fun SidePanelButton(text: String, onClick: () -> Unit) {
    Button(
        onClick,
        Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
    ) {
        Text(text, Modifier.padding(5.dp), MaterialTheme.colors.onSurface)
    }
}