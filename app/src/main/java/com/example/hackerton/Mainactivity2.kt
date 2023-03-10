package com.example.hackerton

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private val pwToggle: ImageView by lazy {
        findViewById(R.id.eye)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val id = findViewById<EditText>(R.id.Id)
        val login = findViewById<Button>(R.id.login)
        val password = findViewById<EditText>(R.id.Password)
        val checkPw = findViewById<EditText>(R.id.password2)
        val intent = Intent(this, LoginActivity::class.java)

        var idmessege = ""
        var pwmessage = ""

        login.isEnabled = false

        pwToggle.setImageResource(R.drawable.hide)
        password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        checkPw.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        pwToggle.setOnClickListener {
            if(pwToggle.tag.equals("0")) {
                pwToggle.tag = "1"
                pwToggle.setImageResource(R.drawable.shape)

                password.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                checkPw.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else if (pwToggle.tag.equals("1")) {
                pwToggle.tag = "0"
                pwToggle.setImageResource(R.drawable.hide)

                password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                checkPw.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
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