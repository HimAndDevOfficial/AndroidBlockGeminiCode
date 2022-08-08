package com.example.androidpracticecode.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidpracticecode.model.FetchRecord
import com.example.androidpracticecode.repository.FetchRecordRepository

class FetchRecordViewModel: ViewModel() {
    var servicesLiveData: MutableLiveData<FetchRecord>? = null

    suspend fun getName() : LiveData<FetchRecord>? {
           servicesLiveData = FetchRecordRepository.getServicesApiCall()
           return  servicesLiveData
       }

}