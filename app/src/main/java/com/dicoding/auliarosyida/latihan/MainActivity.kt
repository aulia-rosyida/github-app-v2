package com.dicoding.auliarosyida.latihan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var widthInput: EditText
    private lateinit var heightInput: EditText
    private lateinit var lengthInput: EditText
    private lateinit var btnCalculate: Button
    private lateinit var resultText: TextView
    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, resultText.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        widthInput = findViewById(R.id.width_input)
        heightInput = findViewById(R.id.height_input)
        lengthInput = findViewById(R.id.length_input)
        btnCalculate = findViewById(R.id.calculate_button)
        resultText = findViewById(R.id.result_text)

        btnCalculate.setOnClickListener(this)

        if(savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            resultText.text = result
        }
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.calculate_button){
            val inputLength = lengthInput.text.toString().trim()
            val inputHeight = heightInput.text.toString().trim()
            val inputWidth = widthInput.text.toString().trim()

            var isEmptyFields = false

            when{
                inputLength.isEmpty() -> {
                    isEmptyFields = true
                    lengthInput.error = getString(R.string.isiDulu)
                }
                inputWidth.isEmpty() -> {
                    isEmptyFields = true
                    widthInput.error = getString(R.string.isiDulu)
                }
                inputHeight.isEmpty() -> {
                    isEmptyFields = true
                    heightInput.error = getString(R.string.isiDulu)
                }
            }

            if(!isEmptyFields) {
                val volume = inputLength.toDouble() * inputHeight.toDouble() * inputWidth.toDouble()
                resultText.text = volume.toString()
            }
        }
    }
}