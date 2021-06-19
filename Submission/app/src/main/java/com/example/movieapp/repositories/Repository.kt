package com.example.movieapp.repositories

import androidx.lifecycle.LiveData
import com.example.movieapp.data.entity.Movie
import com.example.movieapp.data.entity.TvShow
import com.example.movieapp.data.remote.DataSource
import com.example.movieapp.data.remote.RemoteDataSource


class Repository private constructor(private val remoteDataSource: RemoteDataSource) : DataSource {

    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(remoteData: RemoteDataSource): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteData)
            }
    }
    override fun getMovie(
        apiKey: String,
        language: String,
        page: Int
    ): LiveData<List<Movie>> {
        return remoteDataSource.getMovie()
    }

    override fun getTvShow(
        apiKey: String,
        language: String,
        page: Int
    ): LiveData<List<TvShow>> {
        return remoteDataSource.getTvShow()
    }

    override fun getMovieById(id: Int): LiveData<Movie> {
        return remoteDataSource.getMovieById(id)
    }

    override fun getTvById(id: Int): LiveData<TvShow> {
        return remoteDataSource.getTvById(id)
    }

}