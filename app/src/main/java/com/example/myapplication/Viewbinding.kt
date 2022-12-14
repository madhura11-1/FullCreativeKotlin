package com.example.myapplication

fun main(args: Array<String>){

    /*

    findviewbyId - normal simple method wich locates ur id from xml

                   dis -> find the hierarchy in the layout file takes time
                          if view not present runtime nullpointer exception generated
                          type casting manually
                          boilerplate code more (every view write the methods, assign value, type cast)

     AndroidX syntetics - autogenerated class of all view in layout is created
                          directly access layout views thru names

                  adv -> no boiler plate code
                         type safety as class will detect the view type
                         safe from null pointer but partially

                  disavd -> null pointer exception if you have same ids on diff layouts and u refer to other layours id in this layout
                             i.e. global exposure of the view ids in all layouts
                            not interoperable with java (as most code bases in java)

     View binding - binds view references

                   adv -> Null safety — as null views would have @nullable annotation
                          Type safety — as class identifies the type
                          No boilerplate code — all layouts are by default eligible for the generation of binding class without any tag.
                          Supports both Kotlin and Java.









     */




}