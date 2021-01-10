package com.jcozy.trolly.network

import com.bumptech.glide.annotation.GlideExtension
import com.jcozy.trolly.network.responseData.ResponseAdData
import com.jcozy.trolly.network.responseData.ResponseMainMainData
import com.jcozy.trolly.network.responseData.ResponseMainSubData
import com.jcozy.trolly.network.responseData.ResponseMainTimeAttackData
import com.jcozy.trolly.network.responseData.*
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

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
    //광고 퀘스트 보여주기
    @GET("/quest/ad")
    fun requestAd(@HeaderMap headers: Map<String, String?>): Call<ResponseAdData>
    //퀘스트 실시간 인증
    // @GET("/quest/detail/time/{questIdx}")
    //fun requestTimeReview(@HeaderMap headers: Map<String, String?>,  @Path("questIdx") questIdx: Int): Call<>
    //퀘스트 세부 페이지
    @GET("/quest/detail/{questIdx}")
    fun requestQuestDetail(@HeaderMap headers: Map<String, String?>, @Path("questIdx") questIdx: String): Call<ResponseQuestDetailData>
    //타임어택 세부 페이지
    @GET("/quest/detail/{questIdx}")
    fun requestTADetail(@HeaderMap headers: Map<String, String?>, @Path("questIdx") questIdx: String): Call<ResponseTADetailData>

    //퀘스트 후기 사진
    @GET("/quest/detail/images/{questIdx}")
    fun requestQuestDetailReview(@HeaderMap headers: Map<String, String?>, @Path("questIdx") questIdx: String): Call<ResponseQuestDetailReviewData>
    //퀘스트 후기 사진 업로드
    @POST("/quest/upload/{questIdx}")
    fun requestQuestDetailReviewUpload(@HeaderMap headers: Map<String, String?>, @Body body: MultipartBody.Part, @Path("questIdx") questIdx: String): Call<ResponseQuestDetailReviewUploadData>
    //마이페이지 랭킹
    //@GET("/user/mypage/rank")
    //fun requestRanking(@HeaderMap headers: Map<String, String?>): Call<ResponseMypageRankingData>
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