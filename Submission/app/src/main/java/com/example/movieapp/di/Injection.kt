package com.example.movieapp.di

import android.content.Context
import com.example.movieapp.data.remote.CallNetwork
import com.example.movieapp.data.remote.RemoteDataSource
import com.example.movieapp.repositories.Repository

object Injection {

    fun provideRepository(context: Context): Repository {

        val remoteDataSource = RemoteDataSource.getInstance(CallNetwork(context))

        return Repository.getInstance(remoteDataSource)
    }
}