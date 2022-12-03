package com.example.retrofit_57.repository

import com.example.retrofit_57.api.RetrofitInstance
import com.example.retrofit_57.model.Post

class Repository {

    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }
}