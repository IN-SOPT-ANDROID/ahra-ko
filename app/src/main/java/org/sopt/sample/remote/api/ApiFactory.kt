package org.sopt.sample.remote.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.sopt.sample.remote.service.SignInService
import org.sopt.sample.remote.service.SignUpService
import retrofit2.Retrofit

object ApiFactory {
    val retrofit : Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("http://3.39.169.52:3000/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> create(): T = retrofit.create <T> (T::class.java)
}

object  ServicePool {
    val signInService = ApiFactory.create<SignInService>()
    val signUpService = ApiFactory.create<SignUpService>()
}

