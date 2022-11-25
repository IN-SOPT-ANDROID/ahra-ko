package org.sopt.sample.SignUp.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sample.SignIn.view.SignInActivity
import org.sopt.sample.databinding.ActivitySignUpBinding
import org.sopt.sample.remote.api.RequestSignUp
import org.sopt.sample.remote.api.ResponseSignUp
import org.sopt.sample.remote.api.ServicePool
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private var signupService = ServicePool.signUpService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSign.isEnabled = false
        btnActivated()
        clickEvent()
    }

    private fun isEmpty() : Boolean{
        with(binding){
            if (!edtSignupEmail.text.toString().isBlank() &&
                !edtSignupPw.text.toString().isBlank() &&
                !edtSignupName.text.toString().isBlank()) {
                return true
            }
            return false
        }
    }

    private fun btnActivated(){
        with(binding){
            edtSignupEmail.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(p0: Editable?) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    btnSign.isEnabled = isEmpty()
                }
            })
            edtSignupPw.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(p0: Editable?) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    btnSign.isEnabled = isEmpty()
                }
            })

            edtSignupName.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(p0: Editable?) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    btnSign.isEnabled = isEmpty()
                }
            })
        }
    }

    private fun clickEvent(){
        with(binding){
            btnSign.setOnClickListener{
                signupService.signUp(
                    RequestSignUp(
                        binding.edtSignupEmail.text.toString(),
                        binding.edtSignupPw.text.toString(),
                        binding.edtSignupName.text.toString()
                    )
                ).enqueue(object : Callback <ResponseSignUp> {
                    override fun onResponse(
                        call: Call<ResponseSignUp>,
                        response: Response<ResponseSignUp>
                    ) {
                        if(response.isSuccessful){
                            Toast.makeText(this@SignUpActivity, "회원가입 성공", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@SignUpActivity, SignInActivity::class.java)) //화면전환
                            finish()
                        }
                        else{
                            Toast.makeText(this@SignUpActivity,"회원가입 실패",Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<ResponseSignUp>, t: Throwable) {
                        Toast.makeText(this@SignUpActivity,"서버오류",Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}
