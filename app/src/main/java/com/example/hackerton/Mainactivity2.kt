package com.example.hackerton

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val backBtn = findViewById<ImageButton>(R.id.backbutton)
        val id = findViewById<EditText>(R.id.Id)
        val login = findViewById<Button>(R.id.login)
        val password = findViewById<EditText>(R.id.Password)
        val intent = Intent(this, LoginActivity::class.java)

        var idmessege = ""
        var pwmessage = ""

        login.isEnabled = false
        backBtn.setOnClickListener {
            finish()
        }
        id.addTextChangedListener(/* watcher = */ object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                idmessege = id.text.toString()
                pwmessage = password.text.toString()
                login.isEnabled = idmessege.isNotEmpty()
            }


//        password.addTextChangedListener(object: TextWatcher{
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                pwmessage = password.text.toString()
//                login.isEnabled = idmessege.isNotEmpty()
//            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        login.setOnClickListener {
            startActivity(intent)
        }
    }
}