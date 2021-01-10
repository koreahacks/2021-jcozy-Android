package com.jcozy.trolly.network

import okhttp3.MultipartBody

data class RequestConfirm(
    val profile: MultipartBody.Part
)