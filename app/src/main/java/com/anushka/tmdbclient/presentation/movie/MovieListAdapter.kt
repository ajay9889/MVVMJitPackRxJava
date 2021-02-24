package com.anushka.tmdbclient.presentation.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.anushka.tmdbclient.R
import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.databinding.ListItemBinding
import com.bumptech.glide.Glide

class MovieListAdapter (): RecyclerView.Adapter<MovieViewHolder>() {
    private val myList: ArrayList<Movie> = arrayListOf()
    fun setMovieList(myNewList:List<Movie>){
        myList.clear()
        myList.addAll(ArrayList(myNewList))
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val layoutInflater : LayoutInflater= LayoutInflater.from(parent.context)

        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
        false
        )

        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(myList[position])
    }

    override fun getItemCount(): Int {
        return myList.size
    }


}

class MovieViewHolder (val listItemBinding: ListItemBinding): RecyclerView.ViewHolder(
    listItemBinding.root
) {

    fun bind(movie: Movie){
        listItemBinding.titleTextView.text = movie.title
        listItemBinding.descriptionTextView.text = movie.overview

        val posterURL = "https://image.tmdb.org/t/p/w500"+movie.poster_path;
        Glide.with(listItemBinding.imageView.context).
        load(posterURL)
            .into(listItemBinding.imageView)
    }
}