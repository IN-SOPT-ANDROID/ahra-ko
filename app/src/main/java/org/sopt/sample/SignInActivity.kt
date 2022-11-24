package org.sopt.sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import org.sopt.sample.databinding.ActivitySignInBinding
import org.sopt.sample.remote.RequestSignIn
import org.sopt.sample.remote.ResponseSignIn
import org.sopt.sample.remote.ServicePool
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private var loginService = ServicePool.signInService
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            loginService.login(
                RequestSignIn(
                    binding.edtEmail.text.toString(),
                    binding.edtPw.text.toString()
                )
            ).enqueue(object : Callback<ResponseSignIn> {
                override fun onResponse(
                    call: Call<ResponseSignIn>,
                    response: Response<ResponseSignIn>
                ) {
                    if(response.isSuccessful){
                        val intent = Intent(this@SignInActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Snackbar.make(binding.root, "error", Snackbar.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<ResponseSignIn>, t: Throwable) {
                    Snackbar.make(binding.root, "서버 통신 장애", Snackbar.LENGTH_LONG).show()
                }
            })
        }

        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}