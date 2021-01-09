package com.jcozy.trolly.network.responseData


data class ResponseQuestDetailReviewData(

    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<QuestDetailReviewData>
)


data class QuestDetailReviewData(
    val _id : String,
    val image_url : String
)


