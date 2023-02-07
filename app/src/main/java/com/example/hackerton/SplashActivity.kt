package com.example.hackerton

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton


class SplashActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_background)
        val intent = Intent(this, LoginActivity::class.java)
        val loginbtn = findViewById<ImageButton>(R.id.splash)

        loginbtn.setOnClickListener {
            startActivity(intent)
        }
    }
    companion object {
        private const val DURATION : Long = 2000
    }
}