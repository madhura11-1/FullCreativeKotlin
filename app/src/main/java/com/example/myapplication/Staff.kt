package com.example.myapplication

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalTime
import kotlin.math.log

class Staff : Person() {

//    override lateinit var name: String
//    override lateinit var email: String
//    override lateinit var phoneNumber : String
//    override lateinit var loginId: String
//    override lateinit var password : String
    lateinit var startDay : LocalTime
    lateinit var EndDay : LocalTime
    lateinit var seriveName : String
    var slots : LinkedHashMap<Pair<LocalTime,LocalTime>,Int> = linkedMapOf()

    companion object {
        @JvmStatic
        val staffs: ArrayList<Staff> = arrayListOf<Staff>()
    }

    fun add(name : String, email : String, phoneNumber: String,loginId: String,password: String,startDay : LocalTime, endDay : LocalTime,service: String, slots : LinkedHashMap<Pair<LocalTime,LocalTime>,Int>){

        this.name = name
        this.email = email
        this.phoneNumber = phoneNumber
        this.loginId = loginId
        this.password = password
        this.startDay = startDay
        this.EndDay = endDay
        this.seriveName = service
        this.slots = slots
        staffs.add(this)

    }

    override fun updateName(name: String) {
        this.name = name
    }

    override fun updateEmail(email: String) {
        this.email = email
    }

    override fun updatephoneNumber(phoneNumber: String) {
        this.phoneNumber = phoneNumber
    }

    override fun updateLogin(loginId: String) {
        this.loginId = loginId
    }

    override fun updatePassword(password: String) {
        this.password = password
    }

    fun updateWorkinghr(startDay: LocalTime,endDay: LocalTime){
        this.startDay = startDay
        this.EndDay = endDay
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun updateSlot(slotnumber : Int){

        var count = 1
        for ((k, v) in slots) {

            if(slotnumber.equals(count)){
                slots.replace(k,1)
                break;
            }else{
                count++
            }

        }

    }
}