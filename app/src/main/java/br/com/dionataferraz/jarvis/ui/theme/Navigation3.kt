//package br.com.dionataferraz.jarvis.ui.theme
//
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material.BottomNavigationItem
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Favorite
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.NavDestination.Companion.hierarchy
//import androidx.navigation.NavGraph.Companion.findStartDestination
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.currentBackStackEntryAsState
//import androidx.navigation.compose.rememberNavController
//import br.com.dionataferraz.jarvis.FavoriteScreen
//import br.com.dionataferraz.jarvis.HomeScreen
//import br.com.dionataferraz.jarvis.Screen
//import br.com.dionataferraz.jarvis.items
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Preview
//@Composable
//fun Navigation3() {
//    val navController = rememberNavController()
//
//    Scaffold(
//        bottomBar = {
//            NavigationBar {
//                val navBackStackEntry by navController.currentBackStackEntryAsState()
//                val currentDestination = navBackStackEntry?.destination
//                items.forEach { screen ->
//                    BottomNavigationItem(
//                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
//                        label = { Text(stringResource(screen.resourceId)) },
//                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
//                        onClick = {
//                            navController.navigate(screen.route) {
//                                // Pop up to the start destination of the graph to
//                                // avoid building up a large stack of destinations
//                                // on the back stack as users select items
//                                popUpTo(navController.graph.findStartDestination().id) {
//                                    saveState = true
//                                }
//                                // Avoid multiple copies of the same destination when
//                                // reselecting the same item
//                                launchSingleTop = true
//                                // Restore state when reselecting a previously selected item
//                                restoreState = true
//                            }
//                        }
//                    )
//                }
//            }
//        }
//    ) { innerPadding ->
//        NavHost(navController, startDestination = Screen.Home.route, Modifier.padding(innerPadding)) {
//            composable(Screen.Home.route) { HomeScreen() }
//            composable(Screen.Favorite.route) { FavoriteScreen() }
//        }
//    }
//}