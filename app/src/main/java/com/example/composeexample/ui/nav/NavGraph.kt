package com.example.composeexample.ui.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeexample.ui.character.CharacterRoute
import com.example.composeexample.ui.episode.EpisodeRoute
import com.example.composeexample.ui.location.LocationRoute

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = "characters",
        modifier = modifier
    ) {
        composable(BottomNavItem.CharacterList.screenRoute) {
            CharacterRoute()
        }
        composable(BottomNavItem.EpisodeList.screenRoute) {
            EpisodeRoute()
        }
        composable(BottomNavItem.LocationList.screenRoute) {
            LocationRoute()
        }
    }
}
