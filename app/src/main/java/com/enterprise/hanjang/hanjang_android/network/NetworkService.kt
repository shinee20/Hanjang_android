package com.enterprise.hanjang.hanjang_android.network

import com.enterprise.hanjang.hanjang_android.base.BaseModel
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

}