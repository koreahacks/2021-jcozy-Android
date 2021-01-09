package com.jcozy.trolly.network.responseData

data class ResponseMypageRankingData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<RankingData>
)

data class RankingData(
    val profile : String,
    val name : String,
    val ranking : Int
)