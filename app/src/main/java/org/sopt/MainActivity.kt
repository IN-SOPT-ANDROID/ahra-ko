package com.sopt.week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import com.sopt.week1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val startForResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val userId = result.data?.getStringExtra("userId") ?: ""
                val userPw = result.data?.getStringExtra("userPw") ?: ""
                val userMbti = result.data?.getStringExtra("userMbti") ?: ""

                binding.btnLogin.setOnClickListener{
                    if( (binding.edtId.text.toString() == userId) && (binding.edtPw.text.toString() == userPw)){
                        val intent = Intent(this@MainActivity, HomeActivity::class.java)

                        intent.putExtra("userId",userId)
                        intent.putExtra("userMbti",userMbti)

                        Toast.makeText(this,"로그인에 성공했습니다",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"로그인에 실패했습니다",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.btnSignup.setOnClickListener {
            val intent = Intent(this@MainActivity, SignUpActivity::class.java)
            startForResult.launch(intent)
        }
        
    }

}
