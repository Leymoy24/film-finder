package com.example.filmfinder.di.component

import com.example.filmfinder.MainActivity
import com.example.filmfinder.di.module.ViewModelModule
import com.example.filmfinder.di.scope.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = ([ViewModelModule::class]))
interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivityComponent
    }

    fun inject(activity: MainActivity)
}