package br.com.jarvis.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.jarvis.navigation.di.NavigatorComponent
import br.com.jarvis.scopes.ComponentHolder

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screenRoute) {
        composable(BottomNavItem.Home.screenRoute) {
            ComponentHolder.component<NavigatorComponent>().homeNavigator().ShowHomeScreen()
        }
        composable(BottomNavItem.Favorite.screenRoute) {
            FavoriteScreen()
        }
    }
}