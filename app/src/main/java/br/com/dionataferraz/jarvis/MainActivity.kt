package br.com.dionataferraz.jarvis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.dionataferraz.jarvis.ui.theme.JarvisTheme
import br.com.jarvis.navigation.NavigationScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JarvisTheme {
                NavigationScreen()
            }
        }
    }
}
