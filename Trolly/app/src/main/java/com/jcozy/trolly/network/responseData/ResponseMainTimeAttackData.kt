package com.jcozy.trolly.network.responseData

data class ResponseMainTimeAttackData(

    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<MainTimeAttackData>
)

data class MainTimeAttackData(

    val image : String,
    val title : String,
    val start : String,
    val end : String,
    val participant : Int,
    val _id : String

)