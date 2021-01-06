package com.example.layoutdemos2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun clickADButton(view: View) {
        // Do something in response to button
        val intent = Intent(this, SecondActivity::class.java);
        startActivity(intent)
    }
}