package com.example.myapplication

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.LinkedHashMap

class Access {

    @RequiresApi(Build.VERSION_CODES.O)
    fun adminFunctions(admin : Admin){

        val reader = Scanner(System.`in`)
        println("Enter the login id")
        val loginId = reader.nextLine()
        println("Enter the password")
        val password = reader.nextLine()
        if(admin.loginId.equals(loginId) && admin.password.equals(password)) {


            println("Welcome Admin")
            var ok: Boolean = true
            while (ok) {
                println("Enter 1 to create a service")
                println("Enter 2 to create a staff")
                println("Enter 3 to update particular staff details")
                println("Enter 4 to update particular service details")
                println("Enter 5 to view all staff")
                println("Enter 6 to view all services")
                println("Enter 7 to view all customers")
                println("Enter 8 to exist as admin")

                val choice = reader.nextInt()
                when (choice) {
                    1 -> {
                        admin.createService()
                    }
                    2 -> {
                        admin.addStaff()
                    }
                    3 -> {
                        admin.updateStaff()
                    }
                    4 -> {
                        admin.updateService()
                    }
                    5 -> {
                        admin.getAllStaff()
                    }
                    6 -> {
                        admin.getAllService()
                    }
                    7 -> {
                        admin.getAllCustomers()
                    }
                    8 -> ok = false
                    else -> println("Please enter a proper choice")
                }


            }
        }else{
            println("Please enter a proper login Id and password")
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun staffFunctions(){

        val reader = Scanner(System.`in`)
        println("Enter the login id")
        val loginId = reader.nextLine()
        println("Enter the password")
        val password = reader.nextLine()
        val staffs : ArrayList<Staff> = Staff.staffs
        var flag : Boolean = false
        for(index in staffs.indices) {
            val staff = staffs[index]
            if(staff.loginId.equals(loginId) && staff.password.equals(password)){
                flag = true
                var ok = true
                while(ok) {
                    println("Enter 1 to view your details")
                    println("Enter 2 to update your details")
                    println("Enter 3 to exit")
                    val choice = reader.nextInt()
                    when (choice) {

                        1 -> {

                            println("Name : " + staff.name)
                            println("Email : " + staff.email)
                            println("Phone Number : " + staff.phoneNumber)
                            println("Login Id : " + staff.loginId)
                            println("Working Hours : " + staff.startDay + " - " + staff.EndDay)
                            println("Slots booked for the day")
                            val slots : LinkedHashMap<Pair<LocalTime,LocalTime>,Int> = staff.slots
                            slots.forEach { (k, v) ->
                                println(" Slot Time -> $k and Booked(1)/Not(0) -> $v")
                            }
                            println("Service Name : " + staff.seriveName)
                            val servicesall: ArrayList<Service> = AllServices.allServices
                            for (i in servicesall.indices) {
                                val service = servicesall[i]
                                if (service.Name.equals(staff.seriveName)) {

                                    println("Duration of Service : " + service.duration)
                                    val bookings: ArrayList<Booking> = service.bookings
                                    for (j in bookings.indices) {
                                        val book = bookings[j]
                                        if (book.staffName.equals(staff.name)) {
                                            println("Booking Id : " + book.bookingNumber)
                                            println("Customer Name : " + book.customerName)
                                            println("Date of booking : " + book.date.toString())
                                            println("Booking Time : " + book.startTime + " - " + book.endTime)
                                        }


                                    }

                                }

                            }

                        }
                        2 -> {
                            var ok1 = true
                            while (ok1) {
                                println("Enter 1 to update name \n Enter 2 to update email \n Enter 3 to update phone number \n Enter 4 to update loginId \n Enter 5 to update password \n Enter 6 to exit")
                                val choice1 = reader.nextInt()
                                when (choice1) {
                                    1 -> {
                                        println("Enter the new name")
                                        staff.updateName(reader.next())
                                    }
                                    2 -> {
                                        println("Enter the new email")
                                        val email = reader.next()
                                        if(Admin.checkMail(email)) {
                                            staff.updateEmail(email)
                                        }else{
                                            println("Please enter a valid email")
                                        }
                                    }
                                    3 -> {
                                        println("Enter the new phone Number")
                                        val pn = reader.next()
                                        if(Admin.checkNumber(pn)) {
                                            staff.updatephoneNumber(pn)
                                        }else{
                                            println("Please enter a valid phone number")
                                        }
                                    }
                                    4 -> {
                                        println("Enter the new loginId")
                                        staff.updateLogin(reader.next())
                                    }
                                    5 -> {
                                        println("Enter the new password")
                                        staff.updatePassword(reader.next())
                                    }
                                    6 -> ok1 = false
                                    else -> println("Please enter a proper choice")
                                }

                            }
                        }
                        3 -> ok = false
                        else -> println("Please enter a proper choice")
                    }
                }
            }
        }
        if(!flag){
            println("No such staff exists")
        }


    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun customerFunctions(flag : Boolean){
            val reader = Scanner(System.`in`)
            println("Enter the login id")
            val loginId = reader.nextLine()
            println("Enter the password")
            val password = reader.nextLine()
            var flag1 = false
            val allCustomers : ArrayList<Customer>  = Customer.customers
            for(i in allCustomers.indices) {
                val customer = allCustomers[i]
                if(customer.loginId.equals(loginId) && customer.password.equals(password)){
                    flag1 = true
                    var ok = true
                    while(ok) {
                        println("Enter 1 to view your details")
                        println("Enter 2 to update your details")
                        println("Enter 3 to book an appointment")
                        println("enter 4 to exit")
                        val choice = reader.nextInt()
                        when(choice){
                            1 -> {
                                println("Name : " + customer.name)
                                println("Email : " + customer.email)
                                println("Phone Number : " + customer.phoneNumber)
                                println("Login Id : " + customer.loginId)
                                println("Password : " + customer.password)
                                val servicesall : ArrayList<Service> = AllServices.allServices
                                val serviceNames = customer.serviceNames
                                println("Number of Services booked by ${customer.name} ${serviceNames.size}")
                                for(x in serviceNames.indices){
                                    val service = serviceNames[x]
                                    for(j in servicesall.indices){
                                        val ser = servicesall[j]
                                        if(ser.Name.equals(service)){
                                            println("Name : " + ser.Name)
                                            println("Duration : " + ser.duration)
                                            println("Cost : " + ser.cost)
                                            println("Booking of ${customer.name}")
                                            val bookings : ArrayList<Booking> = ser.bookings
                                            for(k in bookings.indices){
                                                val book = bookings[k]
                                                println("Booking Id : " + book.bookingNumber)
                                                println("Staff Name : " + book.staffName)
                                                println("Date of booking : " + book.date.toString())
                                                println("Booking Time : " + book.startTime + " - " + book.endTime)
                                            }
                                        }
                                    }

                                }
                            }
                            2 ->{

                                var ok2 = true
                                while(ok2){
                                println("Enter 1 to update name")
                                println("Enter 2 to update email")
                                println("Enter 3 to update phone number")
                                println("Enter 4 to update login id")
                                println("Enter 5 to update password")
                                println("Enter 6 to exist")
                                val choice3 = reader.nextInt()
                                when(choice3){

                                    1 -> {
                                        println("Please enter the new name")
                                        customer.updateName(reader.nextLine())
                                    }
                                    2 -> {
                                        println("Enter the new email")
                                        val email = reader.next()
                                        if(Admin.checkMail(email)) {
                                            customer.updateEmail(email)
                                        }else{
                                            println("Please enter a valid email")
                                        }
                                    }
                                    3 -> {
                                        println("Enter the new phone Number")
                                        val pn = reader.next()
                                        if(Admin.checkNumber(pn)) {
                                            customer.updatephoneNumber(pn)
                                        }else{
                                            println("Please enter a valid phone number")
                                        }
                                    }
                                    4 -> {
                                        println("please enter new login id")
                                        customer.updateLogin(reader.nextLine())
                                    }
                                    5 -> {
                                        println("Please enter new password")
                                        customer.updatePassword(reader.nextLine())
                                    }
                                    6 -> ok2 = false
                                    else -> println("Please enter a proper choice")

                                }
                                }


                            }
                            3 -> {

                                println("Following are the service available")
                                val servicesall : ArrayList<Service> = AllServices.allServices
                                for(y in servicesall.indices){
                                    val service = servicesall[y]
                                    println("Service Id : $y")
                                    println("Service Name : " + service.Name)
                                    println("Cost of service : " + service.cost)
                                    println("Duration of Service : " + service.duration)
                                    println(" ")
                                }
                                println("Enter the service Id you want to book")
                                val serviceId = reader.nextInt()
                                if(serviceId < servicesall.size){

                                    val service = servicesall[serviceId]
                                    val staffs : ArrayList<Staff> = Staff.staffs
                                    var flags = false
                                    for(index in staffs.indices) {
                                        val staff = staffs[index]
                                        if(staff.seriveName.equals(service.Name)){
                                            flags = true
                                            println("Staff Id : $index" )
                                            println("Name : " + staff.name)
                                            println("Email : " + staff.email)
                                            println("Phone Number : " + staff.phoneNumber)
                                            println("Working Hours : " + staff.startDay + " - " + staff.EndDay)

                                        }
                                    }
                                    if(flags){
                                    println("Please enter the staff Id you want to book with")
                                    val staffId = reader.nextInt()
                                    if(staffId < staffs.size){
                                        val staff = staffs[staffId]
                                        println("Book from among the available slots of ${staff.name}")
                                        val slott : LinkedHashMap<Pair<LocalTime,LocalTime>,Int> = staff.slots
                                        var no = 1
                                        for ((k, v) in slott) {
                                            if(v.equals(0)){
                                                println("$no : Time : $k = Booked/Not : $v")
                                            }
                                            no++
                                        }
                                        println("Enter the slot number")
                                        val slotnumber = reader.nextInt()
                                        if(slotnumber < slott.size){

                                            staff.updateSlot(slotnumber)

                                        }else{
                                            println("Please enter a proper slot number")
                                        }

                                    }
                                    else{
                                        println("This staff id does not exists")
                                    }
                                    }else{
                                        println("No service available for this staff")
                                    }
                                }else{
                                    println("This particular service is not available")
                                }





                            }
                            4 -> {
                                ok = false
                            }
                            else -> println("Please enter a proper choice")
                        }
                    }

                } 

            }

            if(!flag1){
                println("No such customer exists")
            }


        }

    @RequiresApi(Build.VERSION_CODES.N)
    fun customerNew(){
        val reader = Scanner(System.`in`)
        println("Enter the name")
        val name = reader.nextLine()
        println("Enter the email id")
        val email = reader.nextLine()
        println("Enter the phone number")
        val phone = reader.nextLine()
        println("Enter the login id")
        val login = reader.nextLine()
        println("Enter the password")
        val password = reader.nextLine()
        val customer = Customer()
        customer.addCustomer(name,email,phone,login,password)
        customerFunctions(true)

    }


    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        @JvmStatic
        fun main(args: Array<String>) {

            val access = Access()
            val reader = Scanner(System.`in`)
            var ok : Boolean = true
            try {
                while (ok) {
                    println("Welcome")
                    println("Enter 1 to Login as Admin")
                    println("Enter 2 to login as Staff")
                    println("Enter 3 to login as Customer")
                    println("Enter 4 to create an account of Customer")
                    println("Enter 5 to exit")
                    val choice = reader.nextInt()
                    when (choice) {
                        1 -> {
                            println("Logging in as Admin")
                            val admin = Admin()
                            access.adminFunctions(admin)
                        }
                        2 -> {
                            println("Logging in as Staff")
                            access.staffFunctions()
                        }
                        3 -> {
                            println("Logging in as Customer")
                            access.customerFunctions(false)

                        }
                        4 -> {
                            println("Creating a Customer Account")
                            access.customerNew()
                        }
                        5 -> ok = false
                        else -> println("Please enter a proper choice")
                    }
                }
            }catch (exception: InputMismatchException) {
                    println("Please enter an integer value")
                }
        }
    }


}