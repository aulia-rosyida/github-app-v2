package com.dicoding.auliarosyida.listveggie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class profile : AppCompatActivity() {
    private var title: String = "Developer Profile"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}