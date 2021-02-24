package com.anushka.tmdbclient.presentation.tv

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewOutlineProvider
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.anushka.tmdbclient.R
import com.anushka.tmdbclient.databinding.ActivityTvShowBinding
import com.anushka.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class TvShowsActivity : AppCompatActivity(){

    @Inject
    lateinit var factory: TvShowViewModelFactory

    lateinit var viewModel: TvShowViewModel

    val adapter : TvShowsListing = TvShowsListing()

    lateinit var binding: ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_tv_show)

        (application as Injector).createTvShowSubComponent().inject(this)
        viewModel= ViewModelProvider(this, factory).get(TvShowViewModel::class.java)

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
        viewModel.getTvShowsList().observe(this, Observer {
            binding.progressBar.visibility = View.GONE
            if(it!=null ){
                adapter.setTvShowList(it)
            }

        }
        )
    }

    fun updateDataOfMoview(){
        binding.progressBar.visibility = View.VISIBLE
        viewModel.updateTvShowsList().observe(this, Observer {
            if(it!=null ){
                adapter.setTvShowList(it)
            }
            binding.progressBar.visibility = View.GONE
        }
        )

    }
}