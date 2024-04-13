package com.example.filmfinder.data.source

import com.example.filmfinder.BuildConfig
import com.example.filmfinder.data.model.GenreModel
import com.example.filmfinder.data.model.MovieModel
import com.example.filmfinder.data.model.PosterModel
import com.example.filmfinder.data.model.RatingModel
import com.example.filmfinder.data.model.VotesModel
import com.example.filmfinder.data.network.ActorModelSerializable
import com.example.filmfinder.data.network.MovieModelSerializable

object Constants {
    const val API_KEY: String = BuildConfig.API_KEY_KINOPOISK_DEV
    const val pageLimit = 10

    const val genresField = "genres.name"
    const val countriesField = "countries.name"

    val movieSelectedFields = listOf(
        "id",
        "name",
        "description",
        "rating",
        "poster",
        "genres",
        "year",
        "ageRating",
        "isSeries",
        "votes"
    )

    val actorSelectedFields = listOf(
        "id",
        "name",
        "photo"
    )

    val movieRemoteTest = MovieModelSerializable(
        id = 3242,
        name = "Один дома",
        description = "Американское семейство отправляется из Чикаго в Европу, но в спешке сборов бестолковые родители забывают дома... одного из своих детей. Юное создание, однако, не теряется и демонстрирует чудеса изобретательности. И когда в дом залезают грабители, им приходится не раз пожалеть о встрече с милым крошкой.",
        rating = RatingModel(kp = 4.5f),
        poster = PosterModel(
            url = "https://image.openmoviedb.com/kinopoisk-images/6201401/022a58e3-5b9b-411b-bfb3-09fedb700401/orig",
            previewUrl = "https://image.openmoviedb.com/kinopoisk-images/6201401/022a58e3-5b9b-411b-bfb3-09fedb700401/x1000"
        ),
        genres = listOf(
            GenreModel("комедия"),
            GenreModel("семейный"),
        ),
        year = 1990,
        ageRating = 0,
        isSeries = false,
        votes = VotesModel("1000", null, null, null, null, null)
    )


    val movieTest = MovieModel(
        id = 3242,
        name = "Один дома",
        description = "Американское семейство отправляется из Чикаго в Европу, но в спешке сборов бестолковые родители забывают дома... одного из своих детей. Юное создание, однако, не теряется и демонстрирует чудеса изобретательности. И когда в дом залезают грабители, им приходится не раз пожалеть о встрече с милым крошкой.",
        ratingKp = 4.5f,
        posterPreviewUrl = "https://image.openmoviedb.com/kinopoisk-images/6201401/022a58e3-5b9b-411b-bfb3-09fedb700401/x1000",
        genres = listOf("комедия", "семейный"),
        year = 1990,
        ageRating = 0,
        isSeries = false,
        votesKp = "1000"
    )

    val actorsTest = listOf(
        ActorModelSerializable(
            id = 443,
            name = "Елизавета Козлова",
            photo = "https://avatars.mds.yandex.net/get-kinopoisk-image/4303601/d11e99d0-45da-4389-8dff-c2bf33aaf3b7/orig"
        ),
        ActorModelSerializable(
            id = 444,
            name = "Джексон Штайн",
            photo = "https://avatars.mds.yandex.net/get-kinopoisk-image/1777765/a166f62d-974c-4840-ac32-a016440955c4/orig"
        ),
        ActorModelSerializable(
            id = 445,
            name = "Варвара Коробкова",
            photo = null
        ),
    )
}