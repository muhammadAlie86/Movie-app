package com.example.movieapp.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.BuildConfig
import com.example.movieapp.api.Constant.Companion.LANGUAGE
import com.example.movieapp.api.Constant.Companion.PAGE
import com.example.movieapp.data.SampleDataDummy
import com.example.movieapp.data.entity.Movie
import com.example.movieapp.data.entity.TvShow
import com.example.movieapp.data.remote.RemoteDataSource
import com.example.movieapp.utils.FakeRepository
import com.example.movieapp.utils.LiveDataTestUtils
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test

import org.junit.Before
import org.junit.Rule
import org.mockito.Mockito.*


class RepositoryTest {

    private val listMovie = SampleDataDummy.generateSampleMovieDataDummy()
    private var movieId = listMovie[0].id
    private val listTv = SampleDataDummy.generateSampleTvDataDummy()
    private val tvId = listTv[0].id

    private val responseMovie = SampleDataDummy.generateSampleMovieDataDummy()
    private val responseTv = SampleDataDummy.generateSampleTvDataDummy()

    private val remote = mock(RemoteDataSource::class.java)
    private val repository = FakeRepository(remote)
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
    }
    @Test
    fun getMovie() {
        val dummyMovie : MutableLiveData<List<Movie>> = MutableLiveData()
        dummyMovie.value = responseMovie
        `when`(remote.getMovie()).thenReturn(dummyMovie)
        val result = LiveDataTestUtils.getValue(repository.getMovie())

        verify(remote).getMovie()
        assertNotNull(result)
        assertEquals(responseMovie.size.toLong(), responseMovie.size.toLong())


    }

    @Test
    fun getTvShow() {
        val dummyTv : MutableLiveData<List<TvShow>> = MutableLiveData()
        dummyTv.value = responseTv
        `when`(remote.getTvShow()).thenReturn(dummyTv)

        val result = LiveDataTestUtils.getValue(repository.getTvShow())
        verify(remote).getTvShow()
        assertNotNull(result)
        assertEquals(responseTv.size.toLong(), responseTv.size.toLong())


    }

    @Test
    fun getMovieById() {
        val dummyMovieById : MutableLiveData<Movie> = MutableLiveData()
        dummyMovieById.value = listMovie[0]
        `when`(movieId?.let { remote.getMovieById(it) }).thenReturn(dummyMovieById)

        val result = LiveDataTestUtils.getValue(repository.getMovieById(movieId ?: 0))

        verify(remote).getMovieById(movieId ?: 0)
        assertNotNull(result)
        assertEquals(listMovie.size.toLong(), listMovie.size.toLong())


    }

    @Test
    fun getTvById() {
        val dummyTvById : MutableLiveData<TvShow> = MutableLiveData()
        dummyTvById.value = listTv[0]

        `when`(tvId?.let { remote.getTvById(it) }).thenReturn(dummyTvById)

        val result = LiveDataTestUtils.getValue(repository.getTvById(movieId ?: 0))

        verify(remote).getTvById(movieId ?: 0)
        assertNotNull(result)
        assertEquals(listTv.size.toLong(), listTv.size.toLong())


    }
}