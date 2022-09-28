package br.com.dionataferraz.jarvis.di

import br.com.jarvis.scopes.AppScope
import br.com.jarvis.scopes.SingleIn
import com.squareup.anvil.annotations.MergeComponent

@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface AppComponent