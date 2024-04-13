package com.example.filmfinder.ui.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.filmfinder.R
import com.example.filmfinder.data.model.MovieModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onClickAllMovies: () -> Unit
) {
    val pagerMovies by viewModel.pagerMovies.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.main_screen_title),
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onClickAllMovies() }) {
                        Icon(
                            painterResource(id = R.drawable.menu_all_films_icon),
                            contentDescription = "All films",
                            modifier = Modifier.size(28.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
    ) { scaffoldPadding ->

        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
        ) {
            Text(
                text = stringResource(id = R.string.main_screen_popular),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(scaffoldPadding)
                    .padding(horizontal = 32.dp)
            )

            CustomHorizontalPager(pagerMovies = pagerMovies.ifEmpty {
                listOf(
                    MovieModel(
                        id = 4,
                        name = "Загрузка",
                        description = "Загрузка",
                        ratingKp = 9.87f,
                        posterPreviewUrl = null,
                        genres = listOf("Загрузка")
                    )
                )
            })
        }
    }
}