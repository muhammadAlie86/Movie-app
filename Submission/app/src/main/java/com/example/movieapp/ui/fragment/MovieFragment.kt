package com.example.movieapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.BuildConfig
import com.example.movieapp.adapter.MovieAdapter
import com.example.movieapp.api.Constant.Companion.LANGUAGE
import com.example.movieapp.api.Constant.Companion.PAGE
import com.example.movieapp.data.entity.Movie
import com.example.movieapp.databinding.FragmentMovieBinding
import com.example.movieapp.ui.activity.DetailActivity
import com.example.movieapp.utils.DataCallbackMovie
import com.example.movieapp.viewmodel.MovieViewModel
import com.example.movieapp.viewmodel.ViewModelFactory

class MovieFragment : Fragment() , DataCallbackMovie{

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater,container,false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if (activity != null) {
            val movieAdapter = MovieAdapter(this)
            val viewModelFactory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(
                MovieViewModel::class.java)

            viewModel.getMovie(BuildConfig.API_KEY,LANGUAGE, PAGE)
                .observe(viewLifecycleOwner, {
                movieAdapter.setMovie(it)
                with(fragmentMovieBinding.rvMovie) {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = movieAdapter
                }
            })
        }

    }

    override fun setDataMovie(data: Movie) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_DATA,data.id)
        intent.putExtra(DetailActivity.EXTRA_TYPE,DetailActivity.MOVIE_TYPE_ID)
        startActivity(intent)

    }
}