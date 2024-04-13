package com.example.filmfinder

import android.app.Application
import com.example.filmfinder.di.component.DaggerAppComponent

class App : Application(){
    val appComponent = DaggerAppComponent.create()
}