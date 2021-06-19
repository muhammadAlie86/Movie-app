package com.example.movieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.data.entity.Movie
import com.example.movieapp.repositories.Repository


class MovieViewModel (private val repository: Repository): ViewModel() {


    fun getMovie( apiKey : String, language : String, page : Int) : LiveData<List<Movie>> =
        repository.getMovie(apiKey,language,page)

}