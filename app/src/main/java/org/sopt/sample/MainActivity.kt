package com.sopt.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.sopt.week2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.main_container)
        if(currentFragment == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.main_container, HomeFragment())
                .commit()
        }
    }
}
