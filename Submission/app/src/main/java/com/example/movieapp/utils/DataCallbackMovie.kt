package com.example.movieapp.utils

import com.example.movieapp.data.entity.Movie

interface DataCallbackMovie {
    fun setDataMovie(data : Movie)
}