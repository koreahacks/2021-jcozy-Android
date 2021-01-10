package com.jcozy.trolly.network

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
    //퀘스트 세부 페이지
    @GET("/quest/detail/{questIdx}")
    fun requestQuestDetail(@HeaderMap headers: Map<String, String?>, @Path("questIdx") questIdx: String): Call<ResponseQuestDetailData>
    //퀘스트 후기 사진
    @GET("/quest/detail/images/{questIdx}")
    fun requestQuestDetailReview(@HeaderMap headers: Map<String, String?>, @Path("questIdx") questIdx: String): Call<ResponseQuestDetailReviewData>
    //퀘스트 후기 사진 업로드
    @POST("/quest/upload/{questIdx}")
    fun requestQuestDetailReviewUpload(@HeaderMap headers: Map<String, String?>, @Body body: MultipartBody.Part, @Path("questIdx") questIdx: String): Call<ResponseQuestDetailReviewUploadData>
}