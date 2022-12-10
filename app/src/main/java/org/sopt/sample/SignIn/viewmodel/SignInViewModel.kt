package org.sopt.sample.SignIn.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.sample.remote.api.RequestSignIn
import org.sopt.sample.remote.api.ResponseSignIn
import org.sopt.sample.remote.api.ServicePool
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInViewModel : ViewModel() {
    private val _signinResult: MutableLiveData<ResponseSignIn> = MutableLiveData()
    val signinResult: LiveData<ResponseSignIn>
        get() = _signinResult
    private var loginService = ServicePool.signInService

    fun login(email:String, pw:String){
        loginService.login(
            RequestSignIn(email,pw)
        ).enqueue(object : Callback<ResponseSignIn> {
                override fun onResponse(
                    call: Call<ResponseSignIn>,
                    response: Response<ResponseSignIn>
                ) {
                    if (response.isSuccessful) {
                        Log.d("서버 통신 완료!!!!!!!", response.message())
                        _signinResult.value = response.body()
                    } else {
                    }
                }

                override fun onFailure(call: Call<ResponseSignIn>, t: Throwable) {
                    Log.d("서버 오류", t.toString())
                }

            })
    }
}