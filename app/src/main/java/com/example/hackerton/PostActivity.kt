package com.example.hackerton

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class PostActivity: AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pst)
        val intent = Intent(this, ActivityMainWindowMainActivity::class.java)

        val title = findViewById<EditText>(R.id.Title)
        val writing = findViewById<EditText>(R.id.writing)
        val post = findViewById<Button>(R.id.Post)

        var Writing = ""
        var Title = ""

        Writing = writing.text.toString()
        Title = title.text.toString()

        post.setOnClickListener {
            startActivity(intent)
        }
    }
}