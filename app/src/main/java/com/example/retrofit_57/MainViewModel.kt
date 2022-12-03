package com.example.retrofit_57

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_57.model.Post
import com.example.retrofit_57.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val myResponse: MutableLiveData<Post> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response

        }
    }
}