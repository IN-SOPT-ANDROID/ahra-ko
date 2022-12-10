package org.sopt.sample.remote.service

import org.sopt.sample.remote.api.RequestSignUp
import org.sopt.sample.remote.api.ResponseSignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {
    @POST("api/user/signup")
    fun signUp(
        @Body requestSignUp: RequestSignUp
    ) : Call<ResponseSignUp>
}