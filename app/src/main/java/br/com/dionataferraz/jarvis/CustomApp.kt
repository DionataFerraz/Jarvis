package br.com.dionataferraz.jarvis

import android.app.Application
import br.com.dionataferraz.jarvis.di.DaggerAppComponent
import br.com.jarvis.scopes.ComponentHolder

class CustomApp : Application() {
    override fun onCreate() {
        super.onCreate()

        ComponentHolder.components += DaggerAppComponent.create()
    }
}