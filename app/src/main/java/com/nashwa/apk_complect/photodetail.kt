package com.nashwa.apk_complect

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class photodetail : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_photodetail)



        val imageResId = intent.getIntExtra("imageResId", 0)
        val title = intent.getStringExtra("title")


        val imageView = findViewById<ImageView>(R.id.imageViewDetail)
        val textViewTitle = findViewById<TextView>(R.id.textjuduldetail)


        imageView.setImageResource(imageResId)
        textViewTitle.text = title ?: "No Title"



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}