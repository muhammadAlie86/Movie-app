package com.example.movieapp.data.entity

import com.google.gson.annotations.SerializedName


data class TvShow (
    @SerializedName("id")
    val id : Int?,

    @SerializedName("backdrop_path")
    val backdrop_img : String?,

    @SerializedName("original_name")
    val title : String?,

    @SerializedName("poster_path")
    val img_path : String?,

    @SerializedName("original_language")
    val language : String?,

    @SerializedName("overview")
    val overview : String?,

    @SerializedName("first_air_date")
    val release_date : String?,

    @SerializedName("vote_average")
    val vote_average : String?
)
