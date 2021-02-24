package com.anushka.tmdbclient.presentation.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.anushka.tmdbclient.R
import com.anushka.tmdbclient.data.model.tvshows.TVShow
import com.anushka.tmdbclient.databinding.ListItemBinding
import com.bumptech.glide.Glide

class TvShowsListing  (): RecyclerView.Adapter<TvShowViewHolder>() {
    private val myList: ArrayList<TVShow> = arrayListOf()
    fun setTvShowList(myNewList:List<TVShow>){
        myList.clear()
        myList.addAll(ArrayList(myNewList))
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {

        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)

        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )

        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(myList[position])
    }

    override fun getItemCount(): Int {
        return myList.size
    }


}

class TvShowViewHolder (val listItemBinding: ListItemBinding): RecyclerView.ViewHolder(
    listItemBinding.root
) {

    fun bind(tvshow: TVShow){
        listItemBinding.titleTextView.text = tvshow.name
        listItemBinding.descriptionTextView.text = tvshow.original_name

        val posterURL = "https://image.tmdb.org/t/p/w500"+tvshow.poster_path;
        Glide.with(listItemBinding.imageView.context).
        load(posterURL)
            .into(listItemBinding.imageView)
    }
}