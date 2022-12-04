package com.example.retrofit_57.repository

import com.example.retrofit_57.api.RetrofitInstance
import com.example.retrofit_57.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}