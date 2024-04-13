package com.example.filmfinder.data.network

import com.example.filmfinder.data.model.ActorModel

data class ActorModelSerializable(
    val id: Int,
    val name: String?,
    val photo: String?
) {
    fun convertToActorModel() = ActorModel(
        id = id,
        name = name,
        photo = photo
    )
}

data class ActorModelResponseRemote(
    val docs: List<ActorModelSerializable>
)