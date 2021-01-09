package com.jcozy.trolly.network.responseData

data class ResponseTARealtimeData(
    val status : Int,
    val success: Boolean,
    val message: String,
    val data: List<TARealtimeData>
)

data class TARealtimeData(
    val _id : String,
    val name : String,
    val profileImg : String,
    val img_url : String,
    val completed_at : String
)