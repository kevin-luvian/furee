package com.example.furee.appointment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.furee.R
import com.example.furee.appointment.view.*
import com.example.furee.appointment.viewmodel.Bill
import com.example.furee.checkout.CheckoutScreen
import com.example.furee.navigation.NavScreen
import com.example.furee.promo.PromoScreen

object AppointmentScreen : NavScreen("appointment") {
    @Composable
    override fun View(navController: NavController) {
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
                Column(Modifier.padding(20.dp)) {
                    TitleBar()
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    ServiceCard(
                        image = painterResource(id = R.drawable.harold),
                        name = "Dr. Harold Anderson",
                        field = "Cardiovascular",
                        appointment = "1h checkup"
                    )
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    Bills(
                        listOf(
                            Bill("Appointment Cost", "Consultation fee for 1 hour", 19.99f),
                            Bill("Admin Cost", "", 15f),
                        ),
                        onPromoClicked = { navController.navigate(PromoScreen.route) }
                    )
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    PaymentOptions()
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    PayConfirmButton {
                        navController.navigate(CheckoutScreen.routeParams("Dr. Harold Anderson"))
                    }
                }
            }
        }
    }
}