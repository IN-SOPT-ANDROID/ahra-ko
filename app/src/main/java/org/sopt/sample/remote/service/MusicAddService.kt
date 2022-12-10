package org.sopt.sample.remote.service

import retrofit2.Call
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.sopt.sample.remote.api.ResponseMusicAddDTO
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap

interface MusicAddService {
    @Multipart
    @POST("music")
    fun addMusic(
        @Part image : MultipartBody.Part?,
        @Part ("request") request: RequestBody
    ): Call<ResponseMusicAddDTO>
}