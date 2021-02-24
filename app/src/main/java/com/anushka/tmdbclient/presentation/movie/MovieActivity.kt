package com.anushka.tmdbclient.presentation.movie

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anushka.tmdbclient.R
import com.anushka.tmdbclient.databinding.ActivityArtistBinding
import com.anushka.tmdbclient.databinding.ActivityMovieBinding
import com.anushka.tmdbclient.presentation.App
import com.anushka.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity(){

    @Inject
    lateinit var factory: MovieViewModelFactory

    lateinit var viewModel: MovieViewModel

    lateinit var binding: ActivityMovieBinding

    var adapter: MovieListAdapter=MovieListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubComponent().inject(this)
        viewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)
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
         binding.progressBar.visibility =View.VISIBLE
         binding.recyclerView.layoutManager =LinearLayoutManager(this)
         binding.recyclerView.adapter = adapter
         viewModel.getMovie().observe(this, Observer {
             binding.progressBar.visibility =View.GONE
            if(it!=null ){
                adapter.setMovieList(it)
            }

         }
         )
    }

    fun updateDataOfMoview(){
        binding.progressBar.visibility =View.VISIBLE
        viewModel.updateMovie().observe(this, Observer {
            if(it!=null ){
                adapter.setMovieList(it)
            }
            binding.progressBar.visibility =View.GONE
        }
        )

    }

}