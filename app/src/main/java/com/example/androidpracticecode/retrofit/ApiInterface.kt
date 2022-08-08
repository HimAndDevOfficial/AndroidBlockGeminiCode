package com.example.androidpracticecode.retrofit

import com.example.androidpracticecode.model.FetchRecord
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("users?page=1")
    fun getFetchRecordServices() : Call<FetchRecord>

}