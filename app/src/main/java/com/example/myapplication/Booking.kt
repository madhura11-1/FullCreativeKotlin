package com.example.myapplication

import java.time.Duration
import java.time.LocalTime
import java.util.*
import kotlin.properties.Delegates

class Booking {

    companion object {
        @JvmStatic
        var bookingId: Int = 0
}
    var bookingNumber by Delegates.notNull<Int>()
    lateinit var date : Date
    lateinit var customerName : String
    lateinit var staffName : String
    lateinit var startTime : LocalTime
    lateinit var endTime : LocalTime

}