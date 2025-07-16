package com.example.rollerdice

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.rollerdice.presentation.NumbersViewModel
import com.example.rollerdice.presentation.NumbersViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: NumbersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val firstNumber = findViewById<EditText>(R.id.firstNumber)
        val secondNumber = findViewById<EditText>(R.id.secondNumber)
        val messageText = findViewById<TextView>(R.id.messageText)

        viewModel = ViewModelProvider(this, NumbersViewModelFactory())[NumbersViewModel::class.java]

        //ignore section
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                firstNumber.setText(state.run { numberPair.first.toString() })
                secondNumber.setText(state.numberPair.second.toString())
                messageText.text = state.message
            }
        }

    }
}