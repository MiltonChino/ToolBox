package com.example.toolbox

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcButton: Button = findViewById(R.id.calc_button)
        calcButton.setOnClickListener {
            val resultTextView: TextView = findViewById(R.id.textView2)
            resultTextView.text = "Calculator"

        }


    }
}