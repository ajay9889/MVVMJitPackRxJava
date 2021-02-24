package com.anushka.tmdbclient.presentation.artist

import android.app.Application
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.anushka.tmdbclient.R
import com.anushka.tmdbclient.databinding.ActivityArtistBinding
import com.anushka.tmdbclient.databinding.ActivityTvShowBinding
import com.anushka.tmdbclient.presentation.App
import com.anushka.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity(){

    @Inject
    lateinit var factory: ArtistViewModelFactory

    lateinit var viewModel: ArtistViewModel

    lateinit var binding: ActivityArtistBinding

    val adapter: ArtistAdapter= ArtistAdapter();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_artist)

        // injected the artist
        (application as Injector).createArtiSubComponent().inject(this)

        viewModel= ViewModelProvider(this, factory).get(ArtistViewModel::class.java)


        getDisplayList()


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return  when(item.itemId){
            R.id.updateIcon->{
                updateDataOfMoview()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
    fun getDisplayList() {
        binding.progressBar.visibility = View.VISIBLE
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        viewModel.getArtistShowsList().observe(this, Observer {
            binding.progressBar.visibility = View.GONE
            if(it!=null ){
                adapter.setArtistList(it)
            }

        }
        )
    }

    fun updateDataOfMoview(){
        binding.progressBar.visibility = View.VISIBLE
        viewModel.updateArtistShowsList().observe(this, Observer {
            if(it!=null ){
                adapter.setArtistList(it)
            }
            binding.progressBar.visibility = View.GONE
        }
        )

    }
}