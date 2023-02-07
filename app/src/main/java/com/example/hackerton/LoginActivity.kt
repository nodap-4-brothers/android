package com.example.hackerton

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val id: EditText by lazy {
        findViewById(R.id.Id)
    }

    private val loginBtn: Button by lazy {
        findViewById(R.id.loginBtn)
    }

    private val pwToggle: ImageView by lazy {
        findViewById(R.id.iv_eye)
    }

    private val password : EditText by lazy {
        findViewById(R.id.Password)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val intent2 = Intent(this, NaviActivity::class.java)
        val intent = Intent(this, MainActivity2::class.java)
        val make = findViewById<Button>(R.id.Make)

        var idMessege = ""
        var pwmessage = ""


        settingView()

        pwToggle.setOnClickListener {
            if(pwToggle.tag.equals("0")) {
                pwToggle.tag = "1"
                pwToggle.setImageResource(R.drawable.shape)

                password.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else if (pwToggle.tag.equals("1")) {
                pwToggle.tag = "0"
                pwToggle.setImageResource(R.drawable.hide)

                password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }

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

    private fun settingView() {
        pwToggle.bringToFront()

        pwToggle.setImageResource(R.drawable.hide)
        password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
    }

}