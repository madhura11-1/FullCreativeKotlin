package com.example.myapplication

class DataSealedClass {


    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            var user1 = User("Sam", 10)

            var user2 = User("Sam", 10)

            println(user1.toString())  // prints the actual data but if data keywprd was removed address is printed

            if (user1 == user2)    // true; but if data keyword was removed it would print false as reference was comapred
                println("Equal")
            else
                println("Not equal")

            user1.age = 20
            user2.age = 19
            if (user1 == user2)    // this will print equal still as inbuilt methods are applicable only for var in primary constructor
                println("Equal inspite of age")
            else
                println("Not equal")


            var newUser = user1.copy(id = 25)
            println(newUser.component1())
            println(newUser.component2())
            var newUser2 = user1.copy(name = "Samita")
            println(newUser)
            println(newUser2)

            println(Color.values())
            for(x in Color.values()){
                println(x)
            }
            println(Color.BLUE.color)
            println(Color.GREEN.getColor())
        }
    }


    // when u have to deal with data only
    // has toString(), equal(), copy() methods defined in data class

//    The primary constructor needs to have at least one parameter.
//
//    All primary constructor parameters need to be marked as val or var.
//
//    Data classes cannot be abstract, open, sealed, or inner.

    data class User(var name: String, var id: Int){

        var age : Int = 0

    }

    enum class Color(val color : Int){

        RED(10){
            override fun getColor() = "$this" + this.color
        },
        GREEN(20){
            override fun getColor() = "$this" + this.color
                 },
        BLUE(30){
                override fun getColor() = "$this" + this.color
                },
        YELLOW(40){
            override fun getColor() = "$this" + this.color
        };

        abstract fun getColor() : String
    }

}