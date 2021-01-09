package com.jcozy.trolly.network.responseData

data class ResponseMainTimeAttackData(

    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<MainTimeAttackData>
)

data class MainTimeAttackData(

    val timeattackIdx : Int,
    val mainImg : String,
    val name : String,
    val time : String,
    val people : Int

)