package com.example.lab2_integracion_entre_activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Get references to views
        val inputText = findViewById<TextInputEditText>(R.id.inputText)
        val btnSend = findViewById<Button>(R.id.btnSend)
        

        // Set click listener for send button
        btnSend.setOnClickListener {
            // Get text from input field
            val message = inputText.text.toString()

            // Create an intent to start ResultActivity
            val intent = Intent(this, ResultActivity::class.java)

            // Add the message as extra data
            intent.putExtra("MESSAGE_KEY", message)

            // Start the ResultActivity
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}