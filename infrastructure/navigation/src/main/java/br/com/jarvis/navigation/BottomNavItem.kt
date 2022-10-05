package br.com.jarvis.navigation

sealed class BottomNavItem(
    val title: String,
    val icon: Int,
    val selectedIcon: Int,
    val screenRoute: String
) {
    object Home : BottomNavItem("Home", R.drawable.ic_navigation_home, R.drawable.ic_navigation_home, "home")
    object Favorite : BottomNavItem("Favorite", R.drawable.ic_navigation_favorite_unselected, R.drawable.ic_navigation_favorite_selected, "favorite")
}