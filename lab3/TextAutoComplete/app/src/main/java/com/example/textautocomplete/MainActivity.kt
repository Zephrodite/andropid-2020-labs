package com.example.textautocomplete

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get a reference to the AutoCompleteTextView in the layout
        val textView = findViewById(R.id.editCountry) as AutoCompleteTextView

        // Get the string array
        val countries: Array<out String> = resources.getStringArray(R.array.countries_array)

        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries).also { adapter ->
            textView.setAdapter(adapter)
        }
        findViewById<EditText>(R.id.editFirstname).setOnEditorActionListener { v, actionID, event ->
            return@setOnEditorActionListener when (actionID) {
                EditorInfo.IME_ACTION_SEND -> {
                    sendMessage()
                    true
                }
                else -> false
            }
        }
    }

    @SuppressLint("ShowToast")
    private fun sendMessage() {
        val textView = findViewById<EditText>(R.id.editFirstname)
        val text = textView.text.toString()
        Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()

    }
}