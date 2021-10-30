package com.dicoding.provinsibengkulu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class About : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val Kembali: Button = findViewById(R.id.back)
        Kembali.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.back -> {
                val Intent = Intent(this@About, MainActivity::class.java)
                startActivity(Intent)
            }
        }
    }
}