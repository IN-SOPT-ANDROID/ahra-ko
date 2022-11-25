package org.sopt.sample.SignIn.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import org.sopt.sample.MainActivity
import org.sopt.sample.SignUp.view.SignUpActivity
import org.sopt.sample.databinding.ActivitySignInBinding
import org.sopt.sample.SignIn.viewmodel.SignInViewModel

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private val viewModel by viewModels<SignInViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            viewModel.login(
                binding.edtEmail.text.toString(),
                binding.edtPw.text.toString()
            )
        }

        viewModel.signinResult.observe(this){
            val intent = Intent(this@SignInActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}