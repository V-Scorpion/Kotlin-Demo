package com.v_scorpion.kotlinretrofit


import com.v_scorpion.kotlinretrofit.PojoMovie
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<PojoMovie>>
}