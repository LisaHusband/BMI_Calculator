package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtHeight: EditText = findViewById(R.id.edtHeight)
        val edtWeight: EditText = findViewById(R.id.edtWeight)
        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val tvResult: TextView = findViewById(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val heightText = edtHeight.text.toString()
            val weightText = edtWeight.text.toString()

            if (heightText.isEmpty() || weightText.isEmpty()) {
                Toast.makeText(this, "Please enter both height and weight", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height = heightText.toFloat()
            val weight = weightText.toFloat()

            if (height <= 0 || weight <= 0) {
                Toast.makeText(this, "Height and weight must be positive numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Calculate BMI
            val bmi = weight / (height * height)

            // Display result
            tvResult.text = "BMI: %.2f".format(bmi)
        }
    }
}
