package com.zdp.netlibrary

import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 *created on: 2019-12-03
 *
 *@author:bob.zeng
 *
 */
interface ApiService {

    /**
     * 填写Api
     */
    @GET("users/{login}")
    suspend fun getUser(@Path("login") login: String): User
}