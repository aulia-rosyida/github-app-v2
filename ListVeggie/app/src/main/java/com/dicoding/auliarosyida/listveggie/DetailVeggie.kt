package com.dicoding.auliarosyida.listveggie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailVeggie : AppCompatActivity() {
    companion object {
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_veggie)

        val tvImageReceived: ImageView = findViewById(R.id.img_item_photo)
        val tvNameReceived: TextView = findViewById(R.id.tv_item_name)
        val tvDetailReceived: TextView = findViewById(R.id.tv_item_detail)

        val name = intent.getStringExtra(EXTRA_NAME)
        tvNameReceived.text = name.toString()

        val detail = intent.getStringExtra(EXTRA_DETAIL)
        tvDetailReceived.text = detail.toString()

        val photo = intent.getIntExtra(EXTRA_PHOTO,0)
        tvImageReceived.setImageResource(photo)
    }
}