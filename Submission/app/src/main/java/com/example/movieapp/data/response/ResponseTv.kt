package com.example.movieapp.data.response

import com.example.movieapp.data.entity.TvShow
import com.google.gson.annotations.SerializedName

data class ResponseTv (

    @SerializedName("page")
    val page : Int,

    @SerializedName("results")
    val result : List<TvShow>
)