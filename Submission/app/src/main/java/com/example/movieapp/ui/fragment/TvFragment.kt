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
import com.example.movieapp.adapter.TvAdapter
import com.example.movieapp.api.Constant.Companion.LANGUAGE
import com.example.movieapp.api.Constant.Companion.PAGE
import com.example.movieapp.data.entity.TvShow
import com.example.movieapp.databinding.FragmentTvBinding
import com.example.movieapp.ui.activity.DetailActivity
import com.example.movieapp.utils.DataCallbackTv
import com.example.movieapp.viewmodel.TvViewModel
import com.example.movieapp.viewmodel.ViewModelFactory

class TvFragment : Fragment(),DataCallbackTv {


    private lateinit var fragmentTvBinding : FragmentTvBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvBinding = FragmentTvBinding.inflate(layoutInflater,container,false)
        return fragmentTvBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if (activity != null) {
            val tvAdapter = TvAdapter(this)

            val viewModelFactory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(
                TvViewModel::class.java
            )
            viewModel.getTvShow(BuildConfig.API_KEY,LANGUAGE, PAGE)
                .observe(viewLifecycleOwner, {
                tvAdapter.setTvShow(it)
                with(fragmentTvBinding.rvTvShow) {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = tvAdapter
                }

            })
        }
    }

    override fun setDataTv(data: TvShow) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_DATA,data.id)
        intent.putExtra(DetailActivity.EXTRA_TYPE, DetailActivity.TV_TYPE_ID)
        startActivity(intent)

    }
}

