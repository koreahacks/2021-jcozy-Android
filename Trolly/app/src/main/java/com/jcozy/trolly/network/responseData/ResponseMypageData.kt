package com.jcozy.trolly.network.responseData

data class ResponseMypageData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<MypageData>
)

data class MypageData(
    val profileImg : String,
    val name : String,
    val email : String,
    val level : Int,
    val ranking : Int
)