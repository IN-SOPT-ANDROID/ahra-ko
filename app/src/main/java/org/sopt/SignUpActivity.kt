package com.sopt.week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.sopt.week1.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSign.setOnClickListener {
            if (binding.edtSignupId.length() in 6..10 && binding.edtSignupPw.length() in 8..12)  {
                val intent = Intent(this@SignUpActivity, MainActivity::class.java)

                intent.putExtra("userId", binding.edtSignupId.text.toString())
                intent.putExtra("userPw", binding.edtSignupPw.text.toString())
                intent.putExtra("userMbti", binding.edtSignupMbti.text.toString())

                Toast.makeText(this, "회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show()
                setResult(RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(this, "아이디 또는 비밀번호 양식을 지켜주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
