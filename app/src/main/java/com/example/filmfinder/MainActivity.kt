package com.example.filmfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.filmfinder.di.component.ActivityComponent
import com.example.filmfinder.navigation.Navigation
import com.example.filmfinder.ui.theme.FilmFinderTheme
import com.example.filmfinder.util.ViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent = (applicationContext as App).appComponent.activityComponent().create()
        activityComponent.inject(this)

        setContent {

            val navController = rememberNavController()

            FilmFinderTheme {
                Navigation(navController = navController, appContext = applicationContext, viewModelFactory = viewModelFactory)
            }
        }
    }
}