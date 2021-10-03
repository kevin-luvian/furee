package com.example.furee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.furee.appointment.view.AppointmentView
import com.example.furee.ui.component.BillView
import com.example.furee.ui.component.ButtonIcon
import com.example.furee.ui.component.ImageRadioOption
import com.example.furee.ui.theme.FureeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FureeTheme {
                AppointmentView()
            }
        }
    }
}