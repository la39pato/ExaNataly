package com.ucb.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ucb.examen.navigation.AppNavigation
import dagger.hilt.android.AndroidEntryPoint
import com.connectsdk.discovery.DiscoveryManager

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Examen)
        super.onCreate(savedInstanceState)
        DiscoveryManager.init(applicationContext)
        enableEdgeToEdge()
        setContent {
            AppNavigation()

        }
    }
}
