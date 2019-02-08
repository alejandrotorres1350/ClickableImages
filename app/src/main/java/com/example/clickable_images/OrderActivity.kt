package com.example.clickable_images

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        var orderMessage: TextView = findViewById(R.id.orderDescTextView)
        orderMessage.text = intent.getStringExtra("ORDER")
    }
}
