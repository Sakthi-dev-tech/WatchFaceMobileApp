package com.adormantsakthi.watchfacemobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.adormantsakthi.watchfacemobileapp.ui.MainScreen
import com.adormantsakthi.watchfacemobileapp.ui.theme.WatchFaceMobileAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WatchFaceMobileAppTheme {
                MainScreen()
            }
        }
    }
}