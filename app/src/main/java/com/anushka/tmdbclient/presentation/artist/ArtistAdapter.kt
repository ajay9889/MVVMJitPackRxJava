package com.anushka.tmdbclient.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.anushka.tmdbclient.R
import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.databinding.ListItemBinding
import com.bumptech.glide.Glide

class ArtistAdapter(): RecyclerView.Adapter<ArtiViewHolder> () {
    var myArtist: ArrayList<Artist> = arrayListOf();
    fun setArtistList(newList: List<Artist>)
    {
        myArtist.clear()
        myArtist.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtiViewHolder {

        val binding: ListItemBinding  = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item,
            parent,
            false
        )
        return ArtiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtiViewHolder, position: Int) {
        holder.bind(myArtist[position])
    }

    override fun getItemCount(): Int {
       return myArtist.size
    }
}
class ArtiViewHolder (val listItemBinding: ListItemBinding):RecyclerView.ViewHolder(listItemBinding.root){

    fun bind (artist: Artist){

        listItemBinding.titleTextView.text = artist.name
        listItemBinding.descriptionTextView.text =""

        val posterURL = "https://image.tmdb.org/t/p/w500"+artist.profile_path;
        Glide.with(listItemBinding.imageView.context).
        load(posterURL)
            .into(listItemBinding.imageView)

    }
}