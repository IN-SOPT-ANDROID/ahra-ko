package org.sopt.sample.SignUp.viewmodel

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.sample.SignIn.view.SignInActivity
import org.sopt.sample.remote.api.RequestSignUp
import org.sopt.sample.remote.api.ResponseSignIn
import org.sopt.sample.remote.api.ResponseSignUp
import org.sopt.sample.remote.api.ServicePool
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel : ViewModel() {
    private val _signupResult: MutableLiveData<ResponseSignUp> = MutableLiveData()
    val signupResult: LiveData<ResponseSignUp>
        get() = _signupResult
    private var signupService = ServicePool.signUpService

    fun signUp(email:String, pw:String, name:String){
        signupService.signUp(RequestSignUp(email, pw, name)
        ).enqueue(object : Callback<ResponseSignUp>{
                override fun onResponse(
                    call: Call<ResponseSignUp>,
                    response: Response<ResponseSignUp>
                ) {
                    if (response.isSuccessful) {
                        _signupResult.value = response.body()
                    } else {
                    }
                }

                override fun onFailure(call: Call<ResponseSignUp>, t: Throwable) {
                    Log.d("서버 오류", t.toString())
                }
            })
    }


}