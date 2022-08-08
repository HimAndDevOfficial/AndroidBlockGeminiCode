package com.example.androidpracticecode

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpracticecode.Constants.SPLASH_SCREEN_DURATION
import com.example.androidpracticecode.databinding.ActivitySplashBinding
import com.example.androidpracticecode.ui.dashboard.DashboardActivity
import com.example.androidpracticecode.ui.dashboard.FetchRecordFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val binding: ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            finish()
            startActivity(Intent(this@SplashActivity, DashboardActivity::class.java))
        },SPLASH_SCREEN_DURATION)
    }


}