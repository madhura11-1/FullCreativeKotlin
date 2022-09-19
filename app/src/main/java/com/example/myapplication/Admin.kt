package com.example.myapplication

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalTime
import java.time.LocalTime.parse
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.properties.Delegates

class Admin : Person(){

    override var name: String = "Admin"
    override  var email: String = "admin@gmail.com"
    override  var phoneNumber : String = "9876543210"
    override var loginId: String = "admin"
    override var password : String = "admin@anywhere123"


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

    companion object {

        @JvmStatic
        fun checkNumber(s: String): Boolean {
            return if (s.matches(Regex("^(91)?[6-9][0-9]{9}$"))) //919898989898
                true
            else if (s.matches(Regex("^(0)?[6-9][0-9]{9}$")))
                true
            else if (s.matches(Regex("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))) //876.456.4567, 876-456-4567
                true
            else if (s.matches(Regex("\\d{4}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}"))) //3456.345.345, 3456.345-345
                true
            else if (s.matches(Regex("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))) //345-344-3456 x4444
                true
            else if (s.matches(Regex("\\d{1}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")))
                true
            else if (s.matches(Regex("\\d{7,15}")))
                true
            else
                false
        }

        @JvmStatic
        fun checkMail(s: String?): Boolean {
            val regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+\\.[A-Za-z]{2,4}$"
            val pattern: Pattern = Pattern.compile(regex)
            val matcher: Matcher = pattern.matcher(s)
            return matcher.matches()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createSlot(clockin : LocalTime, clockout: LocalTime, duration : Long) : LinkedHashMap<Pair<LocalTime,LocalTime>,Int>{

        val slots : LinkedHashMap<Pair<LocalTime,LocalTime>,Int> = linkedMapOf()
        var yes = true
        var pre = clockin
        while(yes){
            val x = pre.plusMinutes(duration)
            slots.put(Pair(pre,x),0)
            pre = x
            if(pre.compareTo(clockout) >= 0){
                yes = false
            }
        }
        return slots
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addStaff() {

        val reader = Scanner(System.`in`)
        println("Enter the name of the staff")
        val name = reader.nextLine()
        println("Enter the email of the staff")
        val email = reader.nextLine()
        if (Admin.checkMail(email)) {
            println("Enter the phone number of the staff")
            val phoneNumber = reader.nextLine()
            if(checkNumber(phoneNumber)) {
                println("Enter the Clock in time of the staff in format H:mm:ss")
                val clockin: LocalTime =
                    parse(reader.nextLine(), DateTimeFormatter.ofPattern("H:mm:ss"))
                println("Enter the Clock out time of the staff in format H:mm:ss")
                val clockout: LocalTime =
                    parse(reader.nextLine(), DateTimeFormatter.ofPattern("H:mm:ss"))
                println("Enter the name of  service of staff from the below services")
                val servicesall: ArrayList<Service> = AllServices.allServices
                for (i in servicesall.indices) {
                    val servicet = servicesall[i]
                    println("Service $i " + servicet.Name)
                }
                val service = reader.nextLine()
                var staff = Staff()
                var dur by Delegates.notNull<Long>()
                var slots: LinkedHashMap<Pair<LocalTime, LocalTime>, Int> = linkedMapOf()
                for (i in servicesall.indices) {
                    val servicet = servicesall[i]
                    if (servicet.Name.equals(service)) {
                        println("Duration of Service : " + servicet.duration)
                        dur = servicet.duration
                        slots = this.createSlot(clockin, clockout, dur)
                    }
                }
                staff.add(
                    name,
                    email,
                    phoneNumber,
                    "staff",
                    "staff@123",
                    clockin,
                    clockout,
                    service,
                    slots
                )
                println("Staff added successfully")

            }else{
                println("Please enter a valid phone number")
            }
        }else{
            println("Please enter a valid email")
        }
    }

    fun getAllStaff(){

        println("Information of all Staff")
        val staffs : ArrayList<Staff> = Staff.staffs
        for(index in staffs.indices){
            val staff = staffs[index]
            println("Name : " + staff.name)
            println("Email : " + staff.email)
            println("Phone Number : " + staff.phoneNumber)
            println("Login Id : " + staff.loginId)
            println("Working Hours : " + staff.startDay + " - " + staff.EndDay)
            println("Service Name : " + staff.seriveName)
            val servicesall : ArrayList<Service> = AllServices.allServices
            for(i in servicesall.indices){
                val service = servicesall[i]
                if(service.Name.equals(staff.seriveName)){

                    println("Duration of Service : " + service.duration)
                    val bookings : ArrayList<Booking> = service.bookings
                    for(j in bookings.indices){
                        val book = bookings[j]
                        if(book.staffName.equals(staff.name)){
                            println("Booking Id : " + book.bookingNumber)
                            println("Customer Name : " + book.customerName)
                            println("Date of booking : " + book.date.toString())
                            println("Booking Time : " + book.startTime + " - " + book.endTime)
                        }
                    }

                }

            }
            println(" ")

        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun updateStaff(){

        val reader = Scanner(System.`in`)
        var flag : Boolean = false
        println("Enter the name of the staff to update")
        val nameStaff = reader.nextLine()
        val staffs : ArrayList<Staff> = Staff.staffs
        for(index in staffs.indices){
            val staff = staffs[index]
            if(staff.name.contains(nameStaff)){
                flag = true
                println("Enter 1 to update name of staff \n Enter 2 to update email of staff \n Enter 3 to update phone number of staff \n Enter 4  to update Service Name")
                val choice = reader.nextInt()
                when(choice){
                    1 -> {
                        println("Enter the new name")
                        staff.updateName(reader.next())
                    }
                    2 -> {
                        println("Enter the new email")
                        val email = reader.next()
                        if(checkMail(email)) {
                            staff.updateEmail(email)
                        }else{
                            println("Please enter a valid email")
                        }
                    }
                    3 -> {
                        println("Enter the new phone Number")
                        val pn = reader.next()
                        if(checkNumber(pn)) {
                            staff.updatephoneNumber(pn)
                        }else{
                            println("Please enter a valid phone number")
                        }
                    }
                    4 -> {
                        val servicesall : ArrayList<Service> = AllServices.allServices
                        for(i in servicesall.indices) {
                            val servicet = servicesall[i]
                            println("Service $i " + servicet.Name)
                        }
                        staff.seriveName = reader.next()
                    }
                    else -> println("Please enter a proper choice")
                }
            }


        }

        if(!flag){
            println("The name entered does not exists")
        }


    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createService(){

        val reader = Scanner(System.`in`)
        println("Enter the name of the Service")
        val name = reader.nextLine()
        println("Enter the Cost of the Service")
        val cost = reader.nextInt()
        println("Enter the duration of the Service in minutes")
        val duration = reader.nextLong()

        val createService = AllServices()
        createService.createService(name, cost,duration)
        println("Service Created")
    }

    fun getAllService(){

        val servicesall : ArrayList<Service> = AllServices.allServices
        for(i in servicesall.indices){
            val service = servicesall[i]
            println("Service Name : " + service.Name)
            println("Cost of service : " + service.cost)
            println("Duration of Service : " + service.duration)
            val bookings : ArrayList<Booking> = service.bookings
            for(j in bookings.indices){
                    val book = bookings[j]
                println("Booking Id : " + book.bookingNumber)
                    println("Staff Name : " + book.staffName)
                        println("Customer Name : " + book.customerName)
                        println("Date of booking : " + book.date.toString())
                        println("Booking Time : " + book.startTime + " - " + book.endTime)
                }

            println(" ")

            }

        }

    @RequiresApi(Build.VERSION_CODES.O)
    fun updateService(){

        val reader = Scanner(System.`in`)
        println("Enter the name of the service to be updated")
        val serviceName = reader.next()
        var flag : Boolean = false
        val servicesall : ArrayList<Service> = AllServices.allServices
        for(i in servicesall.indices) {
            val service = servicesall[i]
            if(service.Name.contains(serviceName)){
                flag = true
                println("Enter 1 to update Name of service \n Enter 2 to update cost \n Enter 3 to update duration")
                val choice = reader.nextInt()
                when(choice){
                    1 -> {
                        println("Enter the new name of the service")
                        service.Name = reader.next()
                    }
                    2 -> {
                        println("Enter the new cost of the service")
                        service.cost = reader.nextInt()
                    }
                    3 ->{
                        println("Enter the new duration of the service")
                        service.duration = reader.nextLong()
                    }
                    else -> println("Please enter a proper choice")
                }

            }
        }
        if(!flag){
            println("The service you entered does not exists")
        }
    }

    fun getAllCustomers(){

        println("Information of All Customers")
        val allCustomers : ArrayList<Customer>  = Customer.customers
        for(i in allCustomers.indices){
            val customer = allCustomers[i]
            println("Name : " + customer.name)
            println("Email : " + customer.email)
            println("Phone Number " + customer.phoneNumber)
            val servicesall : ArrayList<Service> = AllServices.allServices
            val serviceNames = customer.serviceNames
            println("Number of Services booked by ${customer.name}")
            for(i in serviceNames.indices){
                val service = serviceNames[i]
                    for(j in servicesall.indices){
                        val ser = servicesall[j]
                        if(ser.Name.equals(service)){
                            println("Name : " + ser.Name)
                            println("Duration : " + ser.duration)
                            println("Cost : " + ser.cost)
                            println("Booking of ${customer.name}")
                            val bookings : ArrayList<Booking> = ser.bookings
                            for(j in bookings.indices){
                                val book = bookings[j]
                                println("Booking Id : " + book.bookingNumber)
                                println("Staff Name : " + book.staffName)
                                println("Date of booking : " + book.date.toString())
                                println("Booking Time : " + book.startTime + " - " + book.endTime)
                            }
                        }
                    }

                }

            println(" ")

            }

        }
}

