package com.example.hackerton

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityMainWindowMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)
    }
    class SplashActivity:AppCompatActivity(){

        override fun onCreate(savedlnstanceState:Bundle?){
            super.onCreate(savedlnstanceState)

            val intent = Intent(this,SplashActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
