package com.towich.kinopoiskDev.data.network.serializable

import com.example.filmfinder.data.model.EpisodeModel
import com.example.filmfinder.data.model.PosterModel

data class EpisodeModelSerializable(
    val number: Int?,
    val name: String?,
    val still: PosterModel?,
    val duration: Int?,
    val description: String?
) {
    fun convertToEpisodeModel() = EpisodeModel(
        number = number,
        name = name,
        posterPreview = still?.previewUrl,
        duration = duration,
        description = description
    )
}

data class EpisodeModelResponseList(
    val episodes: List<EpisodeModelSerializable>
)

data class EpisodeModelResponseRemote(
    val docs: List<EpisodeModelResponseList>
)