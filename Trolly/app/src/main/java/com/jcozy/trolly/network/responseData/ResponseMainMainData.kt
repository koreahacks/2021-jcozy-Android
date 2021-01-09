package com.jcozy.trolly.network.responseData


data class ResponseMainMainData(

    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<MainMainData>
)


data class MainMainData(

    val completed : Int,
    val image : String,
    val title : String,
    val level : Int,
    val participant : Int,
    val _id : String

)


