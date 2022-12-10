package org.sopt.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sample.Home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_container, HomeFragment())
            .commit()
    }
}
