package com.adormantsakthi.watchfacemobileapp.ui.navFiles

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adormantsakthi.watchfacemobileapp.ui.screens.Explore
import com.adormantsakthi.watchfacemobileapp.ui.screens.Help
import com.adormantsakthi.watchfacemobileapp.ui.screens.Homescreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            Homescreen()
        }

        composable(route = BottomBarScreen.Help.route) {
            Help()
        }

        composable(route = BottomBarScreen.Explore.route) {
            Explore()
        }
    }
}