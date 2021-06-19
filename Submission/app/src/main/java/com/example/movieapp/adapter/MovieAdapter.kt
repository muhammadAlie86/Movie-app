package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.api.Constant.Companion.POSTER_IMAGE_URL
import com.example.movieapp.utils.DataCallbackMovie
import com.example.movieapp.data.entity.Movie
import com.example.movieapp.databinding.ItemListBinding


class MovieAdapter(private val callback: DataCallbackMovie): RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    private var listMovie : List<Movie> = ArrayList()

    fun setMovie(listMovie : List<Movie>){
        this.listMovie = listMovie
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemListBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(itemListBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovie.size

   inner class MyViewHolder (private val binding : ItemListBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie){

            with(binding){
                binding.tvTitle.text = movie.title
                binding.tvReleaseDate.text = movie.release_date
                binding.tvDescription.text = movie.overview

                imgPoster.setOnClickListener { callback.setDataMovie(movie) }

                Glide.with(itemView.context)
                    .load(POSTER_IMAGE_URL + movie.img_path)
                    .into(imgPoster)
            }
        }
    }
}