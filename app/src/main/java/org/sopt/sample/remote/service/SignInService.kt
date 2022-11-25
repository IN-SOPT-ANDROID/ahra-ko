package org.sopt.sample.remote.service

import org.sopt.sample.remote.api.RequestSignIn
import org.sopt.sample.remote.api.ResponseSignIn
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInService {
    @POST("api/user/signin")
    fun login(
        @Body requestLogin: RequestSignIn
    ): Call<ResponseSignIn>

}