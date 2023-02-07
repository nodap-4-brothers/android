package com.example.hackerton

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.hackerton.databinding.ActivityPstBinding

class PostActivity: AppCompatActivity(){

    private lateinit var binding: ActivityPstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this, ActivityMainWindowMainActivity::class.java)

        var Writing = ""
        var Title = ""

        Writing = binding.writing.text.toString()
        Title = binding.etTitle.text.toString()

        var cnt = ""
        Log.d("testasd", "1234")

        binding.etTitle.addTextChangedListener(object : TextWatcher {
            var maxText = ""
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                maxText = p0.toString()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                cnt = binding.etTitle.text.toString()
                Log.d("testasd", "$cnt d")
                binding.txtCnt.text = "${cnt.length}/15"

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        binding.Post.setOnClickListener {
            startActivity(intent)
        }
    }
}