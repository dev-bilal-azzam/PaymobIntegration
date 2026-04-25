package com.devbilal.paymobintegration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.devbilal.paymobintegration.presentation.PaymentScreen
import com.devbilal.paymobintegration.ui.theme.PaymobIntegrationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PaymobIntegrationTheme {
                PaymentScreen()
            }
        }
    }
}
