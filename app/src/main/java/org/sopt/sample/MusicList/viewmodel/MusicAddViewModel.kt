package org.sopt.sample.MusicList.viewmodel

import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.RequestBody
import org.sopt.sample.ContentUriRequestBody
import org.sopt.sample.remote.api.MusicServicePool
import org.sopt.sample.remote.api.ResponseMusicAddDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MusicAddViewModel : ViewModel() {
    private val _image = MutableLiveData<ContentUriRequestBody>()
    val image : LiveData<ContentUriRequestBody>
        get() = _image
    private var musicAddService = MusicServicePool.musicAddService

    fun setRequestBody(requestBody: ContentUriRequestBody){
        _image.value = requestBody
    }

    fun addMusic(requestBody: RequestBody){
        musicAddService.addMusic(
            image.value!!.toFormData()
        ).enqueue(object: Callback<ResponseMusicAddDTO>{
            override fun onResponse(
                call: Call<ResponseMusicAddDTO>,
                response: Response<ResponseMusicAddDTO>
            ) {
                if(response.isSuccessful){
                    Log.d("tag","success")
                }else{
                    Log.d("tag","fail")
                }
            }

            override fun onFailure(call: Call<ResponseMusicAddDTO>, t: Throwable) {
                Log.e("emergency","서버오류")
            }

        })
    }

}