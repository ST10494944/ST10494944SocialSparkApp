package com.example.socialspark

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.socialsparkapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.timeInput)
        val result = findViewById<TextView>(R.id.resultText)
        val btnSuggest = findViewById<Button>(R.id.btnSuggest)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnSuggest.setOnClickListener {
            val userInput = input.text.toString().trim().lowercase()

            Log.d("USER_INPUT", userInput)

            val suggestion = when (userInput) {
                "morning" -> "Send a Good Morning text to a family member"
                "mid-morning" -> "Say thank you to a colleague"
                "afternoon" -> "Share a funny meme with a friend"
                "snack", "snack time" -> "Send a 'thinking of you' message"
                "dinner" -> "Call a friend for a quick catch-up"
                "night" -> "Leave a kind comment on someone's post"
                else -> "Invalid input. Try: Morning, Afternoon, Night, etc"
            }

            result.text = suggestion
            Toast.makeText(this, suggestion, Toast.LENGTH_SHORT).show()
        }

        btnReset.setOnClickListener {
            input.text.clear()
            result.text = "Your suggestion will appear here"

            Log.d("RESET", "Fields cleared")
        }
    }
}