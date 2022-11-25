package org.sopt.sample.SignUp.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sample.SignIn.view.SignInActivity
import org.sopt.sample.SignUp.viewmodel.SignUpViewModel
import org.sopt.sample.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val viewModel by viewModels<SignUpViewModel>()
    private var idFlag = false
    private var pwFlag = false
    private var nameFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSign.isEnabled = false
        textWatcher()
        clickEvent()
    }

    private fun idRegex(id : String) : Boolean{
        return id.matches("^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{6,10}$".toRegex())
    }

    private fun pwRegex(pw : String) : Boolean{
        return pw.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*?])[A-Za-z[0-9]!@#\$%^&*?]{6,12}$".toRegex())
    }

    private fun flagCheck(){
        binding.btnSign.isEnabled = idFlag && pwFlag && nameFlag
    }

    private fun textWatcher(){
        with(binding){
            edtSignupId.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    if(idRegex(edtSignupId.text.toString())){
                        textinputlayoutId.error = null
                        idFlag = true
                    }
                    else{
                        textinputlayoutId.error = "아이디 형식이 올바르지 않습니다."
                    }
                    flagCheck()
                }
            })

            edtSignupPw.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    if(pwRegex(edtSignupPw.text.toString())){
                        textinputlayoutPw.error = null
                        pwFlag = true
                    }
                    else{
                        textinputlayoutPw.error = "비밀번호 형식이 올바르지 않습니다."
                    }
                    flagCheck()
                }
            })

            edtSignupName.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    if(edtSignupName.text.toString().isNotEmpty()){
                        textinputlayoutName.error = null
                        nameFlag = true
                    }
                    else{
                        textinputlayoutName.error = "이름을 작성해주세요."
                    }
                    flagCheck()
                }
            })
        }
    }

    private fun clickEvent(){
        binding.btnSign.setOnClickListener{
            viewModel.signUp(
                binding.edtSignupId.text.toString(),
                binding.edtSignupPw.text.toString(),
                binding.edtSignupName.text.toString()
            )
        }
        viewModel.signupResult.observe(this){
            Toast.makeText(this@SignUpActivity, "회원가입 성공", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@SignUpActivity, SignInActivity::class.java)) //화면전환
            finish()
        }
    }
}
