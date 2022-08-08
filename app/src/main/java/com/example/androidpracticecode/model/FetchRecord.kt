package com.example.androidpracticecode.model

data class FetchRecord(

    val page : Int,
    val per_page : Int,
    val total : Int,
    val total_pages : Int,
    val data : List<Data>,
    val support : Support
)

data class Data (

    val id : Int,
    val email : String,
    val first_name : String,
    val last_name : String,
    val avatar : String
)

data class Support (

    val url : String,
    val text : String
)