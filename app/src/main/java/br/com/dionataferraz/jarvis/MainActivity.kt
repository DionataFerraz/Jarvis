package br.com.dionataferraz.jarvis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.dionataferraz.jarvis.ui.theme.JarvisTheme
import br.com.dionataferraz.jarvis.ui.theme.Purple400
import br.com.jarvis.home.view.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JarvisTheme {
                MainScreenView()
            }
        }
    }
}

@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                BottomNavigation(navController = navController)
            }
        }
    ) {
        NavigationGraph(navController = navController)
    }
}

/* https://stackoverflow.com/questions/71054138/jetpack-compose-inner-shadow */
fun Modifier.innerShadow() = composed(
    inspectorInfo = {

    },
    factory = {

        val paint = remember() {
            Paint()
        }

        val foregroundPaint = remember() {
            Paint().apply {
                color = Color.Transparent
            }
        }

        val frameworkPaint = remember {
            paint.asFrameworkPaint()
        }

        Modifier.drawWithContent {
            this.drawIntoCanvas {
                val color = Color.LightGray

                val radius = 2.dp.toPx()

                val shadowColor = color
                    .copy(alpha = .7f)
                    .toArgb()
                val transparent = color
                    .copy(alpha = 0f)
                    .toArgb()

                frameworkPaint.color = transparent

                frameworkPaint.setShadowLayer(
                    radius,
                    0f,
                    0f,
                    shadowColor
                )
                val shadowRadius = 4.dp.toPx()

                it.drawRoundRect(
                    left = 0f,
                    top = 0f,
                    right = this.size.width,
                    bottom = this.size.height,
                    radiusX = 4.dp.toPx(),
                    radiusY = 4.dp.toPx(),
                    paint = foregroundPaint
                )

                it.drawRoundRect(
                    left = 0f,
                    top = 0f,
                    right = this.size.width,
                    bottom = this.size.height,
                    radiusX = 4.dp.toPx(),
                    radiusY = 4.dp.toPx(),
                    paint = paint
                )

                it.drawRoundRect(
                    left = shadowRadius,
                    top = shadowRadius,
                    right = this.size.width - shadowRadius,
                    bottom = this.size.height - shadowRadius,
                    radiusX = 4.dp.toPx(),
                    radiusY = 4.dp.toPx(),
                    paint = foregroundPaint
                )
                drawContent()

            }
        }
    }
)

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Favorite,
    )
    BottomNavigation(
        // or NavigationBar
        contentColor = Purple400,
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
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp
                    )
                },
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {
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

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen()
        }
        composable(BottomNavItem.Favorite.screen_route) {
            FavoriteScreen()
        }
    }
}

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {
    object Home : BottomNavItem("Home", R.drawable.ic_navigation_home, "home")
    object Favorite : BottomNavItem("Favorite", android.R.drawable.arrow_down_float, "favorite")
}
