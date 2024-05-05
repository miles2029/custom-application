package com.cam.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

                val myApp = application as MyApplication
                val launchCount = myApp.launchCount

                val textView = findViewById<TextView>(R.id.textView)
                textView.text = "Launch Count: $launchCount"

                val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButtonLight -> myApp.toggleDarkMode(this@MainActivity, false)
                R.id.radioButtonDark -> myApp.toggleDarkMode(this@MainActivity, true)
            }
        }
    }
}
