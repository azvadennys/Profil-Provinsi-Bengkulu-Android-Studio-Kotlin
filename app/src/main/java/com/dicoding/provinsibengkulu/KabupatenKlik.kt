package com.dicoding.provinsibengkulu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class KabupatenKlik : AppCompatActivity(), View.OnClickListener {
    companion object{
        const val EXTRA_DETAIL = "extra_age"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_kabupaten)

        val tvNamaKab: TextView = findViewById(R.id.KAB)
        val tvDEt: TextView = findViewById(R.id.DET)
        val imageDetail: ImageView = findViewById(R.id.img_item_photo)

        val Kembali: Button = findViewById(R.id.back)
        Kembali.setOnClickListener(this)

        tvNamaKab.text = intent.getStringExtra(EXTRA_NAME)
        tvDEt.text = intent.getStringExtra(EXTRA_DETAIL)
        Glide.with(this)
            .load(intent.getIntExtra(EXTRA_PHOTO,0))
            .apply(RequestOptions().override(166, 166))
            .into(imageDetail)
    }



    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.back -> {
                val Intent = Intent(this@KabupatenKlik, MainActivity::class.java)
                startActivity(Intent)
            }
        }
    }
}
