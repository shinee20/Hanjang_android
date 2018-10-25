package com.enterprise.hanjang.hanjang_android.network

import com.enterprise.hanjang.hanjang_android.base.BaseModel
import com.enterprise.hanjang.hanjang_android.model.word.RegistWordData
import com.enterprise.hanjang.hanjang_android.model.word.WordResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*


/**
 * Created by VictoryWoo
 */
interface NetworkService {
    // 통신에 사용할 함수를 정의
    //01. 오늘의 단어 보여주기
    @GET("word")
    fun getTodayWord(
    ):Call<WordResponse>

    //02. 단어 즐겨찾기 등록
    @POST("voca/{uid}")
    fun registToMyVoca(
            @Path("uid") uid:String,
            @Body registWordData : RegistWordData
    ) :Call<BaseModel>

    //03. 단어 즐겨찾기 목록 가져오기
    @GET ("voca/{uid}")
    fun getVocaList(
            @Path("uid") uid:String
    ) :Call<BaseModel>



}