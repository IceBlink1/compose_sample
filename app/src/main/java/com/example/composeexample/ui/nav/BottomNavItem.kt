package com.example.composeexample.ui.nav

import com.example.composeexample.R

sealed class BottomNavItem(
    val title: String,
    val icon: Int,
    val screenRoute: String,
) {

    object EpisodeList: BottomNavItem("Episodes", R.drawable.ic_launcher_background, "episodes")
    object CharacterList: BottomNavItem("Characters", R.drawable.ic_launcher_background, "characters")
    object LocationList: BottomNavItem("Locations", R.drawable.ic_launcher_background, "locations")

}