package com.jcozy.trolly.network

import com.jcozy.trolly.network.requestData.RequestMypage
import com.jcozy.trolly.network.responseData.ResponseMypageData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.Call

interface RequestInterface{
    @GET("/user/mypage")
    fun requestMypage(@Body body: RequestMypage) : Call<ResponseMypageData>
}