package com.enterprise.hanjang.hanjang_android.model.voca

import com.enterprise.hanjang.hanjang_android.model.word.WordData

/**
 * Created by shineeseo on 2018. 10. 25..
 */
data class VocaData (
    var voca_idx : Int,
    var word : WordData,
    var voca_date:String,
    var uid: String

)