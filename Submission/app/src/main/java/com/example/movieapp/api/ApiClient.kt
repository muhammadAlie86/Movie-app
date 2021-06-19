package com.example.movieapp.api

import com.example.movieapp.data.entity.Movie
import com.example.movieapp.data.response.ResponseMovie
import com.example.movieapp.data.response.ResponseTv
import com.example.movieapp.data.entity.TvShow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {

    @GET("movie/now_playing?")
    fun getMovie (
        @Query ("api_key") api_key : String,
        @Query("language") language : String,
        @Query("page") page : Int
    ): Call<ResponseMovie>

    @GET("tv/popular?")
    fun getTvShow(
        @Query ("api_key") api_key : String,
        @Query("language") language : String,
        @Query("page") page : Int
    ): Call<ResponseTv>

    @GET("movie/{movie_id}")
    fun getMovieById(
        @Path("movie_id") id : Int,
        @Query ("api_key") api_key : String,
        @Query("language") language : String
    ): Call<Movie>

    @GET("tv/{tv_id}")
    fun getTvById(
        @Path("tv_id") id : Int,
        @Query ("api_key") api_key : String,
        @Query("language") language : String
    ): Call<TvShow>
}