package com.example.furee.appointment.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.furee.R
import com.example.furee.appointment.viewmodel.Bill
import com.example.furee.ui.component.BillView
import com.example.furee.ui.component.ButtonIcon
import com.example.furee.ui.component.ImageRadioOption
import com.example.furee.ui.theme.DarkGray
import com.example.furee.ui.theme.FureeTheme

@Composable
fun TitleBar(onMenuClick: () -> Unit) {
    Box(Modifier.fillMaxWidth()) {
        ButtonIcon(onMenuClick, R.drawable.ic_menu, Modifier.align(Alignment.CenterStart))
        Text(
            text = "Appointment",
            modifier = Modifier.align(Alignment.Center),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        ButtonIcon({}, R.drawable.ic_bell, Modifier.align(Alignment.CenterEnd))
    }
}

@Composable
fun ServiceCard(
    image: Painter,
    name: String,
    field: String,
    appointment: String
) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        color = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        elevation = 7.dp
    ) {
        Row(Modifier.padding(20.dp), Arrangement.SpaceBetween, Alignment.CenterVertically) {
            Image(
                painter = image,
                contentDescription = "image of $name",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .weight(.25f)
                    .clip(CircleShape)
                    .aspectRatio(1.0f)
            )
            Column(
                Modifier
                    .weight(.75f)
                    .fillMaxWidth()
                    .padding(start = 20.dp)
            ) {
                Text(name, fontSize = 17.sp)
                Text(
                    field,
                    color = DarkGray,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 0.dp, bottom = 10.dp)
                )
                Text(appointment, fontSize = 15.sp)
            }
        }
    }
}

@Composable
fun Bills(bills: List<Bill>, onPromoClicked: (() -> Unit)? = null) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        color = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.primary,
        elevation = 5.dp
    ) {
        Column(Modifier.padding(15.dp)) {
            var totalCost = 0f
            bills.forEach { bill ->
                BillView(
                    modifier = Modifier.padding(bottom = 10.dp),
                    title = bill.title,
                    description = bill.description,
                    cost = bill.cost
                )
                totalCost += bill.cost
            }
            BillView(title = "To pay", cost = totalCost)
            Divider(
                Modifier.padding(vertical = 10.dp),
                color = MaterialTheme.colors.background,
                thickness = 1.dp
            )
            PromoCodeButton { onPromoClicked?.invoke() }
        }
    }
}

@Composable
fun PaymentOptions() {
    var selectedOption by remember { mutableStateOf(0) }

    Surface(
        Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        color = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.primary,
        elevation = 5.dp
    ) {
        Column {
            ImageRadioOption(
                title = "Paypal",
                painter = painterResource(id = R.drawable.paypal),
                modifier = Modifier.padding(15.dp),
                selected = selectedOption == 0,
                onClick = { selectedOption = 0 }
            )
            Divider(
                color = MaterialTheme.colors.background,
                thickness = 1.dp
            )
            ImageRadioOption(
                title = "Credit Card",
                painter = painterResource(id = R.drawable.visa_mastercard),
                modifier = Modifier.padding(15.dp),
                selected = selectedOption == 1,
                onClick = { selectedOption = 1 }
            )
        }
    }
}

@Composable
fun PayConfirmButton(onClick: () -> Unit) {
    Button(
        onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            MaterialTheme.colors.secondary,
            MaterialTheme.colors.onSecondary
        ),
        shape = RoundedCornerShape(15.dp),
    ) {
        Text("Pay & Confirm", Modifier.padding(vertical = 5.dp))
    }
}

@Composable
fun PromoCodeButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            MaterialTheme.colors.secondaryVariant,
            MaterialTheme.colors.secondary
        ),
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.secondary.copy(.2f))
    ) {
        Row(
            Modifier.fillMaxWidth(),
            Arrangement.SpaceBetween,
            Alignment.CenterVertically
        ) {
            Icon(
                painterResource(R.drawable.ic_coupon),
                "coupon icon",
                Modifier.size(20.dp)
            )
            Text(
                "Use Promo Code",
                Modifier.padding(horizontal = 10.dp),
                MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold
            )
            Icon(
                painterResource(R.drawable.ic_arrow_next),
                "arrow next icon",
                Modifier.size(20.dp)
            )
        }
    }
}