package com.jcozy.trolly.network.responseData


data class ResponseQuestDetailReviewUploadData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: QuestDetailReviewUploadData
)

data class QuestDetailReviewUploadData(
    val category: Int,
    val user_level :Int ,
    val main_stamp : Int,
    val sub_stamp : Int
)


