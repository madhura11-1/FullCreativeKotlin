package com.example.myapplication

/*
*   1. Object Declaration
* */
fun main(args: Array<String>) {

    CustomersData.count = 98
    CustomersData.typeOfCustomers()

    println(CustomersData.typeOfCustomers())

    CustomersData.count = 109
    println(CustomersData.count)

    CustomersData.myMethod("hello")

    val x : Int by lazy { 5 }              // here lazy will allocate memory to x only when we will use it until then no memenory will be given
                                          // also once instantiated in all the next calls the cache value which is remembered will be taken
    println("$x")                         // you can use it for val only

    val str : String by lazy {
        println("this will print only once and after that wjenever u call str it will only print the value below and not this print statment")
        "Hello"
    }

    println("$str")
    println("$str")

    // for lateint the memory is allocated only when u assign a value to it
}

open class MySuperClass {

    open fun myMethod(str: String) {
        println("MySuperClass")
    }
}

// object class is actuallt a singelton class
// so compiler creates its own obj once and we cannot create any obj
// we can use it as a static class as only one obj is created
// obj class can inherit other classes and the funtions of inherited class become object's which means we can call them by one obj only


object CustomersData: MySuperClass() { // Object Declaration

    init{
        println("Constructor is not supported in object class as we cannot initiate an object for 'object' class")
    }

    var count: Int = -1             // Behaves like a STATIC variable

    fun typeOfCustomers(): String { // Behaves like a STATIC method
        return "Indian"
    }

    override fun myMethod(str: String) {    // Currently, behaving like a STATIC method
        super.myMethod(str)
        println("object Customer Data: $str")
    }
}


/*
Companion Obj : it helps to declare functions or properties inside a class as static (here it is actually static)
                'object' helps to declare them static outside the class (actually they act as static as only one instance is created)
                @JvmStatic annotation is used : so that even java files can call these static members

  fun main(args: Array<String>) {

    MyClass.count           // You can print it and check result

    MyClass.typeOfCustomers()
  }

  class MyClass {

    companion object {

        var count: Int = -1             // Behaves like STATIC variable

        @JvmStatic
        fun typeOfCustomers(): String { // Behaves like STATIC method
            return "Indian"
        }
    }

 */