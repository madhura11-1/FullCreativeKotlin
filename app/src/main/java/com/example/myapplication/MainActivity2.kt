package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    /*

    with traditional findviewbyid -> sometimes id is not defined
                                     sometimes id is referred from toher activity still it shows no error
                                     sometimes type is not definied

         Viewbinding -> creates a binding class of the xml file and hence all views are referenced thru that class

         disadvantage -> evertime call binding variable
                         time efficiency decreases as here a binding class is created

     */

    private lateinit var binding : ActivityMain2Binding
    private lateinit var testtext : TextView
    private lateinit var texttext1 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.testtext.text = "Hello"

        //proper way to use binding can be
        //here again it is like findviewbyId but you have the null protection
         binding.let {
            testtext = it.testtext
             texttext1 = it.testtext1
        }

    }
}