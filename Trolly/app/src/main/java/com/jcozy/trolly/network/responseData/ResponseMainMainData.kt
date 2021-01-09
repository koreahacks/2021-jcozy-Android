package com.jcozy.trolly.network.responseData


data class ResponseMainMainData(

    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<MainMainData>
)


data class MainMainData(

    val mainmainIdx : Int,
    val mainImg : String,
    val name : String,
    val level : Int,
    val people : Int

)


