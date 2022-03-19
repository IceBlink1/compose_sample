package com.example.composeexample

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.composeexample.ui.nav.BottomNav
import com.example.composeexample.ui.nav.NavGraph

@Composable
fun MainScreenView(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNav(navController = navController) }
    ) {
        NavGraph(navController = navController)
    }
}