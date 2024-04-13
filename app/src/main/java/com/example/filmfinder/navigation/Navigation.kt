package com.example.filmfinder.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.filmfinder.ui.screen.allmovies.AllMoviesScreen
import com.example.filmfinder.ui.screen.allmovies.AllMoviesViewModel
import com.example.filmfinder.ui.screen.filters.FiltersScreen
import com.example.filmfinder.ui.screen.filters.FiltersViewModel
import com.example.filmfinder.ui.screen.main.MainScreen
import com.example.filmfinder.ui.screen.main.MainViewModel
import com.example.filmfinder.ui.screen.movie.MovieScreen
import com.example.filmfinder.ui.screen.movie.MovieViewModel
import com.example.filmfinder.util.ViewModelFactory

@Composable
fun Navigation(
    navController: NavHostController,
    appContext: Context,
    viewModelFactory: ViewModelFactory
) {
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(route = Screen.MainScreen.route) {

            val mainViewModel: MainViewModel =
                ViewModelProvider(it, viewModelFactory)[MainViewModel::class.java]

            MainScreen(
                viewModel = mainViewModel,
                onNavClickSingleMovie = {
                    navController.navigate(Screen.MovieScreen.route)
                },
                onNavClickAllMovies = {
                    navController.navigate(Screen.AllMoviesScreen.route)
                }
            )
        }

        composable(route = Screen.MovieScreen.route) {

            val movieViewModel: MovieViewModel =
                ViewModelProvider(it, viewModelFactory)[MovieViewModel::class.java]

            MovieScreen(
                viewModel = movieViewModel,
                onNavIconClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = Screen.AllMoviesScreen.route) {

            val allMoviesViewModel: AllMoviesViewModel =
                ViewModelProvider(it, viewModelFactory)[AllMoviesViewModel::class.java]

            AllMoviesScreen(
                viewModel = allMoviesViewModel,
                onMovieClicked = {
                    navController.navigate(Screen.MovieScreen.route)
                },
                onFilterIconClicked = {
                    navController.navigate(Screen.FiltersScreen.route)
                },
                onNavIconClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = Screen.FiltersScreen.route) {

            val filtersViewModel: FiltersViewModel =
                ViewModelProvider(it, viewModelFactory)[FiltersViewModel::class.java]

            FiltersScreen(
                appContext = appContext,
                viewModel = filtersViewModel,
                onNavIconClicked = {
                    navController.popBackStack()
                }
            )
        }
    }
}