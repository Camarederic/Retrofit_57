package com.example.retrofit_57.api

import com.example.retrofit_57.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts")
    suspend fun getPost(): Response<Post>
}