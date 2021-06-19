package com.example.movieapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.movieapp.BuildConfig
import com.example.movieapp.api.Constant.Companion.LANGUAGE
import com.example.movieapp.api.Constant.Companion.PAGE
import com.example.movieapp.data.entity.Movie
import com.example.movieapp.data.SampleDataDummy
import com.example.movieapp.repositories.Repository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {


    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<List<Movie>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(repository)
    }

    @Test
    fun getMovie() {

        val dummyMovies: ArrayList<Movie> = SampleDataDummy.generateSampleMovieDataDummy()

        val listMovie: MutableLiveData<List<Movie>> = MutableLiveData()
        listMovie.run {
            setValue(dummyMovies)
        }

        `when`(viewModel.getMovie(BuildConfig.API_KEY, LANGUAGE, PAGE)).thenReturn(listMovie)

        val movieEntities = viewModel.getMovie(BuildConfig.API_KEY, LANGUAGE, PAGE).value
        verify(repository).getMovie(BuildConfig.API_KEY, LANGUAGE, PAGE)

        assertNotNull(movieEntities)
        assertEquals(2, dummyMovies.size)

        viewModel.getMovie(BuildConfig.API_KEY, LANGUAGE, PAGE).observeForever(observer)
        verify(observer).onChanged(dummyMovies)

    }
}