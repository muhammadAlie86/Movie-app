package com.example.movieapp.data.response

import com.example.movieapp.data.entity.Movie
import com.google.gson.annotations.SerializedName

data class ResponseMovie (

    @SerializedName("page")
    val page : Int,

    @SerializedName("results")
    val result : List<Movie>
)