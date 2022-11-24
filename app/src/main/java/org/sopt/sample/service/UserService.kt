package org.sopt.sample.service

import org.sopt.sample.remote.ResponseUser
import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET("api/users")
    fun getUser(): Call<ResponseUser>
}