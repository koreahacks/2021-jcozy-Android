package com.jcozy.trolly.network.responseData

data class ResponseMainSubData(

    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<MainSubData>
)

data class MainSubData(

    val subIdx : Int,
    val mainImg : String,
    val name : String,
    val level : Int,
    val people : Int

)