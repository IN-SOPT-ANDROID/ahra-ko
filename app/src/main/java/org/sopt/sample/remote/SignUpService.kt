package org.sopt.sample.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {
    @POST("api/user/signup")
    fun signUp(
        @Body requestSignupDto: RequestSignUp
    ) : Call<ResponseSignUp>
}