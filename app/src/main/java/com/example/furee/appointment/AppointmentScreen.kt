package com.example.furee.appointment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.furee.R
import com.example.furee.appointment.view.*
import com.example.furee.appointment.viewmodel.Bill
import com.example.furee.checkout.CheckoutScreen
import com.example.furee.navigation.NavScreen
import com.example.furee.promo.PromoScreen
import com.example.furee.ui.component.ScreenSurface
import com.example.furee.ui.theme.FureeTheme
import kotlinx.coroutines.launch

@Preview
@Composable
private fun ContentPreview() {
    val navController = rememberNavController()
    FureeTheme {
        AppointmentScreen.View(navController)
    }
}

object AppointmentScreen : NavScreen("appointment") {
    @Composable
    override fun View(navController: NavController) {
        val scope = rememberCoroutineScope()
        SidePanel(navController) { sidePanelState ->
            ScreenSurface {
                Column(Modifier.padding(20.dp)) {
                    TitleBar(onMenuClick = {
                        scope.launch { sidePanelState.drawerState.open() }
                    })
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