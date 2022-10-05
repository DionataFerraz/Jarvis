package br.com.jarvis.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun NavigationScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                BottomBarNavigation(navController = navController)
            }
        }
    ) {
        NavigationGraph(navController = navController)
    }
}