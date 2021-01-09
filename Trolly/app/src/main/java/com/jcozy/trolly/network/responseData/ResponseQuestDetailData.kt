package com.jcozy.trolly.network.responseData


data class ResponseQuestDetailData(

    val status: Int,
    val success: Boolean,
    val message: String,
    val data: QuestDetailData
)

data class QuestDetailData(
    val participant : Int,
    val completed : Int,
    val _id : String,
    val title : String,
    val sub_title : String,
    val description: String,
    val how_to : String,
    val image : String
)


