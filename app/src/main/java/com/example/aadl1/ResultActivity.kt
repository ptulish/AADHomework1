package com.example.aadl1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_layot)

        val resultTextView: TextView = findViewById(R.id.resultTextView)
        val result = intent.getIntExtra("result", 0)
        resultTextView.text = "Result: $result"

        val resultToolbar: Toolbar = findViewById(R.id.resultToolbar)
        setSupportActionBar(resultToolbar)

        // Enable the back button in the toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        // Handle the back button click
        onBackPressed()
        return true
    }
}