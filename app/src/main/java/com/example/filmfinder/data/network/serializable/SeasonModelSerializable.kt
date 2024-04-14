package com.towich.kinopoiskDev.data.network.serializable

import com.example.filmfinder.data.model.PosterModel
import com.example.filmfinder.data.model.SeasonModel

data class SeasonModelRemote(
    val id: String,
    val name: String?,
    val number: Int?,
    val poster: PosterModel?,
    val episodesCount: Int?
) {
    fun convertToSeasonModel() = SeasonModel(
        id = id,
        name = name,
        number = number,
        previewPoster = poster?.previewUrl,
        episodesCount = episodesCount
    )
}

data class SeasonModelResponseRemote(
    val docs: List<SeasonModelRemote>
)