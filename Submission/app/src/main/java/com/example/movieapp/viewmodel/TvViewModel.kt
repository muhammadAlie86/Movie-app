package com.example.movieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.data.entity.TvShow
import com.example.movieapp.repositories.Repository

class TvViewModel(private val repository: Repository) : ViewModel() {

    fun getTvShow(apiKey : String,language : String,page : Int) : LiveData<List<TvShow>> =
        repository.getTvShow(apiKey,language,page)

}