package com.jcozy.trolly.network.responseData


data class ResponseMypageRankingData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<TotalData>
)


data class TotalData(

    val name : String,
    val profileImg : String
)
