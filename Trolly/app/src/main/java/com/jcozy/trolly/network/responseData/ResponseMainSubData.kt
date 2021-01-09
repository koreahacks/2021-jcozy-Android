package com.jcozy.trolly.network.responseData

data class ResponseMainSubData(

    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<MainSubData>
)

data class MainSubData(

    val completed : Int,
    val image : String,
    val title : String,
    val level : Int,
    val participant : Int,
    val _id : String

)