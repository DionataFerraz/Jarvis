package br.com.jarvis.navigation


sealed class BottomNavItem(val title: String, val icon: Int, val screen_route: String) {
    object Home : BottomNavItem("Home", R.drawable.ic_navigation_home, "home")
    object Favorite : BottomNavItem("Favorite", android.R.drawable.arrow_down_float, "favorite")
}