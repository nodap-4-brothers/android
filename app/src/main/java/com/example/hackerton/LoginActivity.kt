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

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent2 = Intent(this, MainActivity2::class.java)
        val intent = Intent(this, MainActivity2::class.java)
        val id = findViewById<EditText>(R.id.Id)
        val login = findViewById<Button>(R.id.login)
        val password = findViewById<EditText>(R.id.Password)
        val make = findViewById<Button>(R.id.Make)

        var idmessege = ""
        var pwmessage = ""
        login.isEnabled = false


        id.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, before: Int, count: Int){
                idmessege = id.text.toString()
                login.isEnabled = idmessege.isNotEmpty()
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        make.setOnClickListener {
            startActivity(intent)
        }
        login.setOnClickListener {
            startActivity(intent2)
        }
    }
}