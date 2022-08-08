package com.example.androidpracticecode.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.androidpracticecode.model.FetchRecord
import com.example.mvvmkotlinexample.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object FetchRecordRepository {

    val serviceFetchRecord = MutableLiveData<FetchRecord>()

    suspend fun getServicesApiCall(): MutableLiveData<FetchRecord> {
     return withContext(Dispatchers.IO)
     {
         val call = RetrofitClient.apiInterface.getFetchRecordServices()
         call.enqueue(object: Callback<FetchRecord> {
             override fun onFailure(call: Call<FetchRecord>, t: Throwable) {
                 Log.v("DEBUG : ", t.message.toString())
             }

             override fun onResponse(
                 call: Call<FetchRecord>,
                 response: Response<FetchRecord>
             ) {
                 serviceFetchRecord.value = response.body()
             }
         })
         serviceFetchRecord
     }
    }
}

