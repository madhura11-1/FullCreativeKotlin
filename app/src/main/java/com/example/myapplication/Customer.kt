package com.example.myapplication

class Customer : Person() {

//    override lateinit var name: String
//    override lateinit var email: String
//    override lateinit var phoneNumber : String
//    override lateinit var loginId: String
//    override lateinit var password : String
    val serviceNames : ArrayList<String> = arrayListOf()

    companion object{
        @JvmStatic
        val customers : ArrayList<Customer> = arrayListOf()
    }

    fun addCustomer(name : String, email : String, phoneNumber: String,loginId: String,password: String){

        var customer = Customer()
        customer.name = name
        customer.email = email
        customer.phoneNumber = phoneNumber
        customer.loginId = loginId
        customer.password = password
        customers.add(customer)
        println("you are added as a customer")
        
    }

    fun chooseService(name : String){
        serviceNames.add(name)
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
    
}