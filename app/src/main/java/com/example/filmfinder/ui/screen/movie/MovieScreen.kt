package com.example.filmfinder.ui.screen.movie

import androidx.navigation.NavController
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.SubcomposeAsyncImage
import com.example.filmfinder.R
import com.example.filmfinder.data.model.MovieModel
import com.example.filmfinder.data.source.Constants
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MovieScreen(
    viewModel: MovieViewModel,
    onNavIconClicked: () -> Unit
) {
    val movie: MovieModel = viewModel.performGetCurrentMovie() ?: Constants.movieTest
    val actors = viewModel.performGetActors().collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {

                },
                navigationIcon = {
                    IconButton(onClick = {
                        onNavIconClicked()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Back",
                            modifier = Modifier
                                .size(36.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f),
                                    shape = CircleShape
                                )
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            SubcomposeAsyncImage(
                model = movie.posterPreviewUrl,
                contentDescription = "Poster",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .heightIn(max = 600.dp)
                    .shadow(
                        elevation = 15.dp,
                        shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)
                    ),
                loading = {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(600.dp)
                            .background(color = MaterialTheme.colorScheme.surface)
                    ) {
                        CircularProgressIndicator(
                            strokeWidth = 5.dp,
                            modifier = Modifier
                                .size(50.dp),
                        )
                    }
                },
                error = {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(600.dp)
                            .background(color = MaterialTheme.colorScheme.surface)
                    ) {
                        Text(
                            text = stringResource(id = R.string.no_photo),
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )

            Column(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = movie.name ?: stringResource(id = R.string.no_info_name),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )


                Text(
                    text = buildMovieInfoString(movie = movie),
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 10.dp, start = 20.dp, end = 20.dp)
                )

                // Rating + reviews
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star",
                        tint = Yellow,
                        modifier = Modifier.size(20.dp)
                    )

                    val ratingText =
                        String.format(
                            Locale.US, "%.1f", movie.ratingKp ?: 0.0f
                        ) + " (${movie.votesKp} ${stringResource(id = R.string.reviews)})"

                    Text(
                        text = ratingText,
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )
                }
            }

            // Description
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 40.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.description),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = movie.description ?: stringResource(id = R.string.no_info_description),
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(top = 20.dp)
                )
            }

            Column(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.actors),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                )

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                ) {
                    item {
                        Spacer(modifier = Modifier.width(0.dp))
                    }
                    items(actors.itemCount) { index ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                        ) {
                            SubcomposeAsyncImage(
                                model = actors[index]?.photo,
                                contentDescription = "Photo of actor",
                                contentScale = ContentScale.Crop,
                                loading = {
                                    Box(
                                        contentAlignment = Alignment.Center,
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(color = MaterialTheme.colorScheme.surface)
                                    ) {
                                        CircularProgressIndicator(
                                            strokeWidth = 5.dp,
                                            modifier = Modifier
                                                .size(50.dp),
                                        )
                                    }
                                },
                                error = {
                                    Box(
                                        contentAlignment = Alignment.Center,
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(color = MaterialTheme.colorScheme.surface)
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.profile_icon),
                                            contentDescription = "No photo",
                                            tint = MaterialTheme.colorScheme.primary
                                        )
                                    }
                                },
                                modifier = Modifier
                                    .size(96.dp)
                                    .shadow(
                                        elevation = 5.dp,
                                        shape = CircleShape
                                    )
                                    .clip(shape = CircleShape)
                            )

                            Text(
                                text = actors[index]?.name
                                    ?: stringResource(id = R.string.no_info_short),
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(top = 10.dp)
                                    .width(96.dp)
                            )
                        }

                    }
                    item {
                        Spacer(modifier = Modifier.width(0.dp))
                    }
                }
            }

        }
    }
}

@Composable
private fun buildMovieInfoString(movie: MovieModel): String {
    val infoString = StringBuffer()

    if (movie.year != null) {
        infoString.append(movie.year)
        infoString.append(" • ")
    }

    infoString.append(movie.genres.joinToString(", "))

    infoString.append(" • ")
    infoString.append(
        when (movie.isSeries) {
            null -> {
                stringResource(id = R.string.no_info_short)
            }

            true -> {
                stringResource(id = R.string.series)
            }

            false -> {
                stringResource(id = R.string.movie)
            }
        }
    )

    if (movie.ageRating != null) {
        infoString.append(" • ")
        infoString.append("${movie.ageRating}+")
    }

    return infoString.toString()
}