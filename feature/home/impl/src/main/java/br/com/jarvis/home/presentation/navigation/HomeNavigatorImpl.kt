package br.com.jarvis.home.presentation.navigation

import androidx.compose.runtime.Composable
import br.com.jarvis.home.view.HomeScreen
import br.com.jarvis.scopes.AppScope
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class HomeNavigatorImpl @Inject constructor() : HomeNavigator {
    @Composable
    override fun ShowHomeScreen() {
        HomeScreen()
    }
}