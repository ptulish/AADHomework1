package com.example.aadl1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private lateinit var staticTextView: TextView;
    private lateinit var firstInput: EditText;
    private lateinit var secondInput: EditText;
    private lateinit var topBar: Toolbar
    private lateinit var resultTextView: TextView;
    public var sum: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the Toolbar
        topBar = findViewById(R.id.topBar)

        staticTextView = findViewById(R.id.staticTextView);
        firstInput = findViewById(R.id.firstInput);
        secondInput = findViewById(R.id.secondInput);
        resultTextView = findViewById(R.id.result);

        val calculateButton: Button = findViewById(R.id.calculateButton)
        calculateButton.setOnClickListener {
            onButtonClick();
            updateResultText();

        }
        val navigateButton: Button = findViewById(R.id.showResultButton)
        navigateButton.setOnClickListener {
            onButtonClick();
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("result", sum)
            startActivity(intent)
        }
    }

    fun onButtonClick() {
        val first: Int;
        val second: Int;
        if (firstInput.text.toString() == ""){
            first = 0;
        } else {
            first = try {
                firstInput.text.toString().toIntOrNull() ?: 0
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "First input is not a number", Toast.LENGTH_SHORT).show()
                return;
            }
        }
        if (secondInput.text.toString() == ""){
            second = 0;
        } else {
            second = try {
                secondInput.text.toString().toIntOrNull() ?: 0
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Second input is not a number", Toast.LENGTH_SHORT).show()
                return;
            }
        }

        sum = first + second;
    }
    private fun updateResultText() {
        resultTextView.text = "Result: $sum"
    }
}