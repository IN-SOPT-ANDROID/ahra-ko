package org.sopt.sample.remote.service

import org.sopt.sample.remote.api.ResponseMusicShowDTO
import retrofit2.Call
import retrofit2.http.GET

interface MusicShowService {
    @GET("music/list")
    fun showMusic() : Call<ResponseMusicShowDTO>
}