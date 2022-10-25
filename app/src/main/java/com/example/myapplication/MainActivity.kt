package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


// AppCompactActivity() is like base for all other ctivities as it helps to adjust the new features into the older versions fo android
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //calling testtext of other activity still does not give any error that is why we shld use binding as it will give references of only those
        // views which are present as it will create a class of that layout file

        val testtext : TextView = findViewById(R.id.testtext)  // here runtime error will occur

    }
}