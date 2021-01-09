package com.jcozy.trolly.network

import com.jcozy.trolly.network.responseData.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path

interface RequestInterface{

    //타임어택 보여주기
    @GET("/quest/time")
    fun requestTimeAttack(@HeaderMap headers: Map<String, String?>): Call<ResponseMainTimeAttackData>
    //메인 퀘스트 보여주기
    @GET("/quest/main")
    fun requestMainQuest(@HeaderMap headers: Map<String, String?>): Call<ResponseMainMainData>
    //서브 퀘스트 보여주기
    @GET("/quest/sub")
    fun requestSubQuest(@HeaderMap headers: Map<String, String?>): Call<ResponseMainSubData>
    //퀘스트 세부 페이지
    @GET("/quest/detail/{questIdx}")
    fun requestQuestDetail(@HeaderMap headers: Map<String, String?>, @Path("questIdx") questIdx: String): Call<ResponseQuestDetailData>
    //타임어택 세부 페이지
    @GET("/quest/detail/{questidx)")
    fun requestTADetail(@HeaderMap headers: Map<String, String?>, @Path("questIdx") questIdx: String): Call<ResponseTADetailData>

    //퀘스트 후기 사진
    @GET("/quest/images/{questIdx}")
    fun requestQuestDetailReview(@HeaderMap headers: Map<String, String?>, @Path("questIdx") questIdx: String): Call<ResponseQuestDetailReviewData>
    //퀘스트 실시간 인증
    // @GET("/quest/detail/time/{questIdx}")
    //fun requestTimeReview(@HeaderMap headers: Map<String, String?>,  @Path("questIdx") questIdx: Int): Call<>
    //타임어택 실시간 인증
    @GET("/quest/detail/time/{questIdx}")
    fun requestTARealtime(@HeaderMap headers : Map<String, String?>) : Call<ResponseTARealtimeData>

    //mypage 정보 가져오기
    @GET("/user/mypage")
    fun requestMypage(@HeaderMap headers: Map<String, String?>): Call<ResponseMypageData>
}