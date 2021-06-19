package com.example.movieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.data.entity.Movie
import com.example.movieapp.data.entity.TvShow
import com.example.movieapp.repositories.Repository

class DetailViewModel (private val repository: Repository): ViewModel() {


    fun setMovie(movieId : Int) : LiveData<Movie> = repository.getMovieById(movieId)
    fun setTvShow(tvShowId : Int) : LiveData<TvShow> = repository.getTvById(tvShowId)
}