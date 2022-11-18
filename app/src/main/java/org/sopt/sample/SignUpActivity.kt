package org.sopt.sample

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sample.databinding.ActivitySignUpBinding
import org.sopt.sample.remote.RequestSignUp
import org.sopt.sample.remote.ResponseSignUp
import org.sopt.sample.remote.ServicePool
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private var signupService = ServicePool.signUpService
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSign.isEnabled = false
        btnActivated()
        clickEvent()
    }

    private fun isEmpty(): Boolean {
        with(binding) {
            if (!edtSignupEmail.text.toString().isBlank() && !edtSignupPw.text.toString().isBlank()
                && !edtSignupName.text.toString().isBlank()) {
                return true
            }
            return false
        }
    }

    private fun btnActivated() {
        with(binding) {
            edtSignupEmail.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {}
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    btnSign.isEnabled = isEmpty()
                }
            })
            edtSignupPw.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {}
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    btnSign.isEnabled = isEmpty()
                }
            })
            edtSignupName.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {}
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    btnSign.isEnabled = isEmpty()
                }
            })
        }
    }

    private fun clickEvent() {
        with(binding) {
            btnSign.setOnClickListener {
                signupService.signUp(
                    RequestSignUp(
                        edtSignupEmail.text.toString(),
                        edtSignupPw.text.toString(),
                        edtSignupName.text.toString()
                    )
                ).enqueue(object : Callback<ResponseSignUp> {
                    override fun onResponse(
                        call: Call<ResponseSignUp>,
                        response: Response<ResponseSignUp>
                    ) {
                        Toast.makeText(this@SignUpActivity, "회원가입에 성공하였습니다.", Toast.LENGTH_SHORT)
                            .show()
                        startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
                    }

                    override fun onFailure(call: Call<ResponseSignUp>, t: Throwable) {
                        Toast.makeText(this@SignUpActivity, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT)
                            .show()
                    }
                })
            }
        }
    }

}
