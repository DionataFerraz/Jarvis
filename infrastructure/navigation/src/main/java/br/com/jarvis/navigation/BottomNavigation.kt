package br.com.jarvis.navigation

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.com.jarvis.navigation.extensions.innerShadow

@Composable
fun BottomBarNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Favorite,
    )
    BottomNavigation(
        // or NavigationBar
        contentColor = Color(0xFF4C1064)/*Purple400*/,
        backgroundColor = Color.White,
        elevation = 0.dp,
        modifier = Modifier
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .width(IntrinsicSize.Min)
            .innerShadow()
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
                shadowElevation = 20f
            },
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            val isSelected =  currentRoute == item.screenRoute
            val iconSelected =  if (isSelected) {
                item.selectedIcon
            } else {
                item.icon
            }

            BottomNavigationItem(
                selectedContentColor = Color(0xFF4C1064),
                unselectedContentColor = Color(0xFFFFBA49),
                icon = { Icon(painterResource(id = iconSelected), contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp
                    )
                },
                alwaysShowLabel = true,
                selected = isSelected,
                onClick = {
                    navController.navigate(item.screenRoute) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}