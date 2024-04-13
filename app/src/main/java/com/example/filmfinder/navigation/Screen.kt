package com.example.filmfinder.navigation

sealed class Screen(val route: String) {
    data object MainScreen : Screen(route = "main_screen")
    data object MovieScreen : Screen(route = "movie_screen")
    data object AllMoviesScreen : Screen(route = "all_movies_screen")
    data object FiltersScreen : Screen(route = "filters_screen")
}