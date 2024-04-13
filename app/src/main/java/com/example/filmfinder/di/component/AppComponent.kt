package com.example.filmfinder.di.component

import com.example.filmfinder.di.module.AppModule
import com.example.filmfinder.di.module.DomainModule
import com.example.filmfinder.di.module.NetworkModule
import com.example.filmfinder.di.scope.AppScope
import dagger.Component

@AppScope
@Component(modules = [AppModule::class, NetworkModule::class, DomainModule::class])
interface AppComponent {
    fun activityComponent(): ActivityComponent.Factory
}