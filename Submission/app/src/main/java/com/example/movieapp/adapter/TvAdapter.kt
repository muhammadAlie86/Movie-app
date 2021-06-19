package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.api.Constant.Companion.POSTER_IMAGE_URL
import com.example.movieapp.data.entity.TvShow
import com.example.movieapp.databinding.ItemListBinding
import com.example.movieapp.utils.DataCallbackTv

class TvAdapter (private val callback : DataCallbackTv) : RecyclerView.Adapter<TvAdapter.MyViewHolder>() {

    private var listTvShow : List<TvShow> = ArrayList()

    fun setTvShow(listTvShow : List<TvShow>){
        this.listTvShow = listTvShow
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemListBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return MyViewHolder(itemListBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tvShow = listTvShow[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShow.size

    inner class MyViewHolder(private val binding : ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShow: TvShow) {

            with(binding) {

                imgPoster.setOnClickListener { callback.setDataTv(tvShow) }

                binding.tvTitle.text = tvShow.title
                binding.tvReleaseDate.text = tvShow.release_date
                binding.tvDescription.text = tvShow.overview

                Glide.with(itemView.context)
                    .load(POSTER_IMAGE_URL + tvShow.img_path)
                    .into(imgPoster)

            }
        }
    }
}