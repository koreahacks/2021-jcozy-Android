package com.jcozy.trolly.network.responseData

data class ResponseTADetailData (
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: TADetailData
)

data class TADetailData(
    val participant : Int,
    val completed : Int,
    val _id : String,
    val title : String,
    val sub_title : String,
    val description : String,
    val how_to : String,
    val image : String,
    val end : String,
    val start : String
)