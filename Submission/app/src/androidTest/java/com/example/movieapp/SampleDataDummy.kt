package com.example.movieapp

import com.example.movieapp.data.entity.Movie
import com.example.movieapp.data.entity.TvShow

object SampleDataDummy {

    fun generateSampleMovieDataDummy() : ArrayList<Movie>{

        val movies = ArrayList<Movie>()

        movies.add(
            Movie(
                464052,
                "/srYya1ZlI97Au4jUYAktDe3avyA.jpg",
                "Wonder Woman 1984",
                "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                "en",
                "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                "2020-12-16",
                "7"

            )
        )
        movies.add(
            Movie(
                651571,
                "/nz8xWrTKZzA5A7FgxaM4kfAoO1W.jpg",
                "Breanch",
                "/13B6onhL6FzSN2KaNeQeMML05pS.jpg",
                "en",
                "A hardened mechanic must stay awake and maintain an interstellar ark fleeing the dying planet Earth with a few thousand lucky souls on board... the last of humanity. Unfortunately, humans are not the only passengers. A shapeshifting alien creature has taken residence, its only goal is to kill as many people as possible. The crew must think quickly to stop this menace before it destroys mankind.",
                "2021-01-01",
                "5.1"

            )
        )

        return movies
    }
    fun generateSampleTvDataDummy() : ArrayList<TvShow>{

        val movies = ArrayList<TvShow>()

        movies.add(
            TvShow(
                85271,
                "/57vVjteucIF3bGnZj6PmaoJRScw.jpg",
                "WandaVision",
                "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                "en",
                "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
                "2021-01-15",
                "8.4"
            )
        )
        movies.add(
            TvShow(
                69050,
                "/9hvhGtcsGhQY58pukw8w55UEUbL.jpg",
                "Riverdale",
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "en",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "2017-01-26",
                "8.6")
        )
        return movies
    }
}