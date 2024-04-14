package com.towich.kinopoiskDev.data.network.serializable

import com.example.filmfinder.data.model.PosterModel

data class PostersModelSerializable(
    val url: String?,
    val previewUrl: String?
) {
    fun convertToPosterModel() = PosterModel(
        url = url,
        previewUrl = previewUrl
    )
}

data class PosterModelResponseRemote(
    val docs: List<PostersModelSerializable>
)