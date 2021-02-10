package com.example.fragmenttutorial2


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

public final class ExampleFragment : Fragment(R.layout.example_fragment) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater?.inflate(
            R.layout.example_fragment,
            container, false
        )

        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val editText = view.findViewById<EditText>(R.id.editText)
            val resultText = view.findViewById<TextView>(R.id.textView)
            resultText.text = editText.text.toString()
        }
        return view
    }

}