package com.example.movieapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.movieapp.BuildConfig
import com.example.movieapp.api.Constant.Companion.LANGUAGE
import com.example.movieapp.api.Constant.Companion.PAGE
import com.example.movieapp.data.SampleDataDummy
import com.example.movieapp.data.entity.TvShow
import com.example.movieapp.repositories.Repository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class TvViewModelTest{

    private lateinit var viewModel : TvViewModel

    @get:Rule
    var instantTaskExecutorRule =  InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer : Observer<List<TvShow>>


    @Before
    fun setUp(){
        viewModel = TvViewModel(repository)
    }

    @Test
    fun getTvShow() {

        val dummyTv: ArrayList<TvShow> = SampleDataDummy.generateSampleTvDataDummy()

        val listTv: MutableLiveData<List<TvShow>> = MutableLiveData()
        listTv.run {
            setValue(dummyTv)
        }

        `when`(viewModel.getTvShow(BuildConfig.API_KEY, LANGUAGE, PAGE)).thenReturn(listTv)

        val tvEntities = viewModel.getTvShow(BuildConfig.API_KEY, LANGUAGE, PAGE).value
        verify(repository).getTvShow(BuildConfig.API_KEY, LANGUAGE, PAGE)

        assertNotNull(tvEntities)
        assertEquals(2, dummyTv.size)

        viewModel.getTvShow(BuildConfig.API_KEY, LANGUAGE, PAGE).observeForever(observer)
        verify(observer).onChanged(dummyTv)

    }
}