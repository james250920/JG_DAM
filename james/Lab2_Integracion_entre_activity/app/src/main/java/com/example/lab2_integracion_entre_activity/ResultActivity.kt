package com.example.lab2_integracion_entre_activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        // Get references to views
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val buttonReturn = findViewById<Button>(R.id.buttonReturn)

        // Get data from intent
        val message = intent.getStringExtra("MESSAGE_KEY")?:  "No message"

        // Set text to TextView
        textViewResult.text = message

        // Set click listener for return button
        buttonReturn.setOnClickListener {
            finish() // Close this activity and return to previous one
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}