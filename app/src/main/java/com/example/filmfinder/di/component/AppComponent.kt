package com.example.filmfinder.di.component

import android.content.Context
import com.example.filmfinder.di.module.AppModule
import com.example.filmfinder.di.module.DatabaseModule
import com.example.filmfinder.di.module.DomainModule
import com.example.filmfinder.di.module.NetworkModule
import com.example.filmfinder.di.scope.AppScope
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [AppModule::class, NetworkModule::class, DomainModule::class, DatabaseModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun activityComponent(): ActivityComponent.Factory
}