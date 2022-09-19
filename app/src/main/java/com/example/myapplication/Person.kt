package com.example.myapplication

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalTime
import java.time.format.DateTimeFormatter

abstract class Person {

    open lateinit var name : String
    open lateinit var email : String
    open lateinit var phoneNumber : String
    open lateinit var loginId : String
    open lateinit var password : String

    abstract fun updateName(name : String)

    abstract fun updateEmail(email : String)

    abstract fun updatephoneNumber(phoneNumber : String)

    abstract fun updateLogin(loginId : String)

    abstract fun updatePassword(password : String)

    companion object{
        @RequiresApi(Build.VERSION_CODES.O)
        @JvmStatic
        fun main(args: Array<String>){
            var time = "10:00p"
            time = time.replace("p", "PM").replace("a", "AM") // 10:00PM

            val localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("hh:mm a"))
            println(localTime)
        }
    }




    /*
    Aysmptotic Notations :

    For mathematical way of representing the time and space complexity of the algorithms





     */

}