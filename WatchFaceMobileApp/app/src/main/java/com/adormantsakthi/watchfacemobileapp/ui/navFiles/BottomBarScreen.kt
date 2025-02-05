package com.adormantsakthi.watchfacemobileapp.ui.navFiles

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.adormantsakthi.watchfacemobileapp.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val iconRes: Int
) {
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        iconRes = R.drawable.home
    )
    object Help: BottomBarScreen(
        route = "help",
        title = "Help",
        iconRes = R.drawable.helpicon
    )
    object Explore: BottomBarScreen(
        route = "explore",
        title = "Explore",
        iconRes = R.drawable.compass
    )
}
