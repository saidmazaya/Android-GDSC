package com.example.studentproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentproject.R

class AboutPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)
    }
}