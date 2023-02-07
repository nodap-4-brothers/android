package com.example.hackerton

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val id: EditText by lazy {
        findViewById(R.id.Id)
    }

    private val loginBtn: Button by lazy {
        findViewById(R.id.loginBtn)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val intent2 = Intent(this, MainActivity2::class.java)
        val intent = Intent(this, MainActivity2::class.java)
        val password = findViewById<EditText>(R.id.Password)
        val make = findViewById<Button>(R.id.Make)

        var idMessege = ""
        var pwmessage = ""


        id.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, before: Int, count: Int){
                idMessege = id.text.toString()
                loginBtn.isEnabled = idMessege.isNotEmpty()
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        make.setOnClickListener {
            startActivity(intent)
        }
        loginBtn.setOnClickListener {
            startActivity(intent2)
        }
    }
}