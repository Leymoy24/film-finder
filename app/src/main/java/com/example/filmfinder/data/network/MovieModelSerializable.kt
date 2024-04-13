package com.example.filmfinder.data.network

import com.example.filmfinder.data.model.GenreModel
import com.example.filmfinder.data.model.MovieModel
import com.example.filmfinder.data.model.PosterModel
import com.example.filmfinder.data.model.RatingModel
import com.example.filmfinder.data.model.VotesModel

data class MovieModelSerializable(
    val id: Int,
    val name: String,
    val description: String,
    val rating: RatingModel?,
    val poster: PosterModel?,
    val genres: List<GenreModel>,
    val ageRating: Int?,
    val year: Int?,
    val isSeries: Boolean?,
    val votes: VotesModel?,
) {
    fun convertToMovieModel() = MovieModel(
        id,
        name,
        description,
        rating?.kp,
        poster?.previewUrl,
        genres.map { genreModel -> genreModel.name.replaceFirstChar { it.titlecase() } },
        ageRating = ageRating,
        year = year,
        isSeries = isSeries,
        votesKp = votes?.kp
    )
}

data class MovieModelResponseRemote(
    val docs: List<MovieModelSerializable>
)