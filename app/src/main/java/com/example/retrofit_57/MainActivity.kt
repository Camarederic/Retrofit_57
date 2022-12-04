package com.example.retrofit_57

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_57.adapter.MyAdapter
import com.example.retrofit_57.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getCustomPosts(2, "id", "desc")
        viewModel.myCustomPosts.observe(this, Observer { response ->
            if (response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
            }else{
                Toast.makeText(this, response.code(), Toast.LENGTH_LONG).show()
            }

        })

    }

    private fun setupRecyclerView(){
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}