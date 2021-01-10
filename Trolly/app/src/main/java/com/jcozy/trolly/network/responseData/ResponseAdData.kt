package com.jcozy.trolly.network.responseData

data class ResponseAdData(

    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<AdData>
)

data class AdData(

    val completed : Int,
    val sub_title : String,
    val image : String,
    val title : String,
    val level : Int,
    val participant : Int,
    val _id : String

)