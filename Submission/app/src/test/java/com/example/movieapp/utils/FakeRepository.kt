package com.example.movieapp.utils

import androidx.lifecycle.LiveData
import com.example.movieapp.data.entity.Movie
import com.example.movieapp.data.entity.TvShow
import com.example.movieapp.data.remote.RemoteDataSource

class FakeRepository(private val remoteDataSource: RemoteDataSource) {

    fun getMovie(): LiveData<List<Movie>> {
        return remoteDataSource.getMovie()
    }

    fun getTvShow(): LiveData<List<TvShow>> {
        return remoteDataSource.getTvShow()
    }

    fun getMovieById(id: Int): LiveData<Movie> {
        return remoteDataSource.getMovieById(id)
    }

    fun getTvById(id: Int): LiveData<TvShow> {
        return remoteDataSource.getTvById(id)
    }
}