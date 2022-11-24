package org.sopt.sample.service

import org.sopt.sample.remote.RequestSignUp
import org.sopt.sample.remote.ResponseSignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {
    @POST("api/user/signup")
    fun signUp(
        @Body requestSignUp: RequestSignUp
    ) : Call<ResponseSignUp>
}