package com.sopt.week1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sopt.week1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setProfile()
    }

    private fun setProfile(){
        val profileId = intent.getStringExtra("userId")
        val profileMbti = intent.getStringExtra("userMbti")

        binding.tvProfileName.text = "이름 : $profileId"
        binding.tvProfileMbti.text = "MBTI : $profileMbti"
    }
}
