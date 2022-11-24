package org.sopt.sample.service

import org.sopt.sample.remote.RequestSignIn
import org.sopt.sample.remote.RequestSignUp
import org.sopt.sample.remote.ResponseSignIn
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInService {
    @POST("api/user/signin")
    fun login(
        @Body requestLogin: RequestSignIn
    ): Call<ResponseSignIn>

}