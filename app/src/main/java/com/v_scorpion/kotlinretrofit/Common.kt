package com.v_scorpion.kotlinretrofit

import com.v_scorpion.kotlinretrofit.RetrofitServices
import com.v_scorpion.kotlinretrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}