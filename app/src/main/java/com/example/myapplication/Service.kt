package com.example.myapplication

import java.time.LocalTime
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.cos
import kotlin.properties.Delegates

open class Service {

    lateinit var Name : String
    var cost by Delegates.notNull<Int>()
    var duration by Delegates.notNull<Long>()
    val bookings : ArrayList<Booking> = arrayListOf<Booking>()

    fun setNameS(name : String){
        this.Name = name
    }

    fun setCostS(cost : Int){
        this.cost = cost
    }

    fun setIntS(duration: Long){
        this.duration = duration
    }

    fun book(customerName : String, staffName : String, startTime : LocalTime, endTime : LocalTime, date : Date){
        var booking = Booking()
        booking.bookingNumber = Booking.bookingId++
        booking.customerName = customerName
        booking.staffName = staffName
        booking.startTime = startTime
        booking.endTime = endTime
        booking.date = date
        bookings.add(booking)
    }


}