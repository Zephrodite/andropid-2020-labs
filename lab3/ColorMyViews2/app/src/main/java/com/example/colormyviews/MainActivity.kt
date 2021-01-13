package com.example.colormyviews

import android.graphics.Color
import android.graphics.Color.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()

    }
    private fun setListeners() {
        val box_one_text = findViewById<TextView>(R.id.box_one_text)
        val box_two_text = findViewById<TextView>(R.id.box_two_text)
        val box_three_text = findViewById<TextView>(R.id.box_three_text)
        val box_four_text = findViewById<TextView>(R.id.box_four_text)
        val box_five_text = findViewById<TextView>(R.id.box_five_text)
        val constraint_layout = findViewById<ConstraintLayout>(R.id.constraint_layout)
        val red_button = findViewById<Button>(R.id.red_button)
        val yellow_button = findViewById<Button>(R.id.yellow_button)
        val green_button = findViewById<Button>(R.id.green_button)

        var clickableViews: List<View> =
                listOf(box_one_text, box_two_text, box_three_text,
                        box_four_text, box_five_text, constraint_layout,
                    red_button, yellow_button, green_button)

        for (item in clickableViews) {
            item.setOnClickListener{ makeColored(it)}
        }
    }
    fun makeColored(view: View) {
        val box_one_text = findViewById<TextView>(R.id.box_one_text)
        val box_two_text = findViewById<TextView>(R.id.box_two_text)
        val box_three_text = findViewById<TextView>(R.id.box_three_text)
        val box_four_text = findViewById<TextView>(R.id.box_four_text)
        val box_five_text = findViewById<TextView>(R.id.box_five_text)
        val constraint_layout = findViewById<ConstraintLayout>(R.id.constraint_layout)
        val red_button = findViewById<Button>(R.id.red_button)
        val yellow_button = findViewById<Button>(R.id.yellow_button)
        val green_button = findViewById<Button>(R.id.green_button)

        when (view.id) {
            R.id.box_one_text -> view.setBackgroundColor(DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(GRAY)

            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            R.id.red_button -> box_three_text.setBackgroundColor(getResources().getColor(R.color.my_red))
            R.id.yellow_button -> box_four_text.setBackgroundColor(getResources().getColor(R.color.my_yellow))
            R.id.green_button -> box_five_text.setBackgroundColor(getResources().getColor(R.color.my_green))
            else -> view.setBackgroundColor(LTGRAY)
        }
    }

}

