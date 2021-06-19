package com.example.movieapp.data.remote

import androidx.lifecycle.LiveData
import com.example.movieapp.data.entity.Movie
import com.example.movieapp.data.entity.TvShow

interface DataSource {

    fun getMovie(apiKey : String, language : String, page : Int) : LiveData<List<Movie>>
    fun getTvShow(apiKey : String,language : String,page : Int) : LiveData<List<TvShow>>
    fun getMovieById(id : Int) : LiveData<Movie>
    fun getTvById(id : Int) : LiveData<TvShow>
}