package com.example.furee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.furee.navigation.Navigation
import com.example.furee.ui.theme.FureeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FureeTheme {
                Navigation()
            }
        }
    }
}