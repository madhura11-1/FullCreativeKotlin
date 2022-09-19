package com.example.myapplication

class Basic {

    /*

    Kotlin advantages over Java:

Expressive and concise: You can do more with less
Null Pointer Exception is avoided
Interoperable: Call Java-based code from Kotlin, or call Kotlin from Java-based code  (kotlin code is compiled as bytecode which can be executed by JVM)


* u can convert java project to kotlin in android
* u can add kotlin puligin to existing java project so u can have both in same project


Kotlin can be used in Multiplatform :

Kotlin multiplatfrom mobile : ios and android
Kotlin web application
Kotlin mobile + web
Kotlin common libraries

Cross Platform : only one code and work on all platforms
Multiplatform : compatible with the other lan Kotlin/Native, Kotlin/Java, Kotlin/JavaScript


Using semicolons in kotlin :

optional

two case :
1. When u wrtie 2 statements on same line
   println("heelo"); println("hee")

2. In enum at the end of the enum list
   enum abc{
     a,b,c;
   }



Varibale Declaration :

var = when we have to change the value
val = when value has to be fixed

var variable: String = "Hello"
      (name)  (type)   (value)

variable = "Hello all"      // possible to change the namw


var variable2 = "Hello2"    // another form of declaration this will auto put variable2 as of the type 'String'
(type inference i.e. kotlin will come to nkow the type by its value)

var language: String       // not necessary to initialize during the declaration
languaue = "hello"

** -> lateint (Late inititalization)

if u want to initlize the property aftrwards you can use this keyword

lateinit var subject: Int  (so now u can initialize it afterwards)


Kotlin is Statically Types Lang:

var hello = "String"
hello = 4                 // not possible
var hello = 3             // not possible as compiler detects it as string


Type Conversions :

not possible to convert to another data type

var value1 = 10
val value2: Long = value1  //Compile error, type mismatch

solution : val value2: Long = value1.toLong()
                                     toByte()
									 toShort()
									 toInt()
									 toLong()
									 toFloat()
									 toDouble()
									 toChar()


Null Safety :

Java does not provide null safety i.e. it allows a variable to be declared null
Kotlin does not but indirectly we can

Eg : var vairable : String = null;    // error

but if u want to declare:

var variable : String? = null         // '?' here helps to assign a string/null value


Data Types :

Byte, Short, Int, Long, Float, Double, Array, String, Char, Boolean



Array in Kotlin :

arrayOf()  ----> mutable and fixed size
Array()

var array1 = arrayOf(1,2,3,4)     // implicit declaration
var array1 = arrayOf<Int>(1,2,3)  // explicit declaration
val myArray3 = arrayOf<String>("Ajay","Prakesh","Michel","John","Sumit")  //explicit
var myArray4= arrayOf(1,10,4, "Ajay","Prakesh")   //generized

var array2 = Array(5,{i = i+9})   // first argument = size; second argument = function for array values initialization only
var myArray = Array<Int>(5){0}    // size 5 and initializing all ele to 0

output : 9,10,11,12,13

array2.set(1,2) (index,value)
array2.get(0)    (index)

** built in methods to create array:
byteArrayOf()
charArrayOf()
shortArrayOf()
longArrayOf()
intArrayOf()

String in Kotlin :

var string1 =" hello"

var string 2 = """ hello                   //other lines also included
                    hi
                   bye """

Strings in immutable in Kotlin -> every time update happens new string is created


Escaped String : contain escaped characters like \n,\t
Raw String : has no escaped characters

String Templates : print("i = $i") -> value
                   println("$s.length is ${s.length}") // Prints "abc.length is 3"
        Templates can be used in raw as well as escaped strings

Conditions :


if..else

1. if(cindition){

}else if{

}else{

}

2. var hello : String = if(condition){              // return is done implicitly but has to be a string only

}else if{

}else{

}


3. val answerString = when {                        //this is same as if, else if, else statements only
    count == 42 -> "I have the answer."
    count > 35 -> "The answer is close."
    else -> "The answer eludes me."
 }


   when is like a switch statement

   when(ans){

   1 -> println()
   2-> {
        println()
   }
   3,4,5 -> {
      println()
   }
   else ->    //what if else is not there

   }


   when in range:

   when(number) {
        in 1..5 -> println("Input is provided in the range 1 to 5")
        in 6..10 -> println("Input is provided in the range 6 to 10")
        else -> println("none of the above")
    }


Difference between if and when :

use if else only when dealing with 2 conditions
if multiple condition use when

When is more readable, elegant than if..else



 Loopings :


 var array = arrayOf(2,3,4,5)

 for(elemnts in array){
 	println(elemnts)
 }

 //on basis of index

 for(index in array.indices){
    println(array[index])
 }


 for(i in 1..5)    both 1 and 5 included
 println(i)


for(i in 5..1){       //for(i in 5 downTo 2)  -> print ele from 5 to 2
	println(i)
}

for (i in 1..5 step 2)    // 1,3,5

for (i in 0..n - 1) { /*...*/ }  // bad
for (i in 0 until n) { /*...*/ }  // good      as it is a open range better to use until


While Loop :

while(condition){

}

Do while :

do{

}while(condition);



Input :

readLine()  -- reads only String value
               other values need to be converted

Scanner obj -- reads according to java

readline()!! -- only taked non null value as input

eg:

var input : String = readline()   // error coz here we are expectig only not null string

modification:

var input : String? = readline()
            or
var input : String = readline()!!


Operaters :

same as java

Bitwise Operators :

shl (bits) ->	signed shift left	-> a.shl(b)
shr (bits) ->	signed shift right	-> a.shr(b)
ushr (bits) ->	unsigned shift right ->	a.ushr(b)
and (bits) ->	bitwise and	 -> a.and(b)
or (bits) ->	bitwise or	-> a.or(b)
xor (bits)	-> bitwise xor -> a.xor(b)
inv()	-> bitwise inverse	-> a.inv()


** Type conversion in Kotlin has to be explicit


Break :

labeled break : name@

loop1@ for(){
	loop2@ for(){
	   break@loop1   // will specifically break loop1
	}
}


Continue :

labeled continue : name@

loop1@ for(){
	loop2@ for(){
	   continue@loop1   // will specifically continue from loop1
	}
}


Functions :

fun functionName(para1:Int = 5, para2: Int = 6):Int(return type){
	                         |_ Default argument
	//body
	return integer
}

functionName()    // will take default only iguess **check it
functionName(6)   // it will be given to the para1
functionName(para2 = 9) // now para1 -> default value and para2 has value 6
               |_ Named argument


Lambda Functions :

also called as anoymous functions
these dont have any name
just the argument type and the return type is expected and inside curly brackets the statments

val lambdaFun : Int(argument) -> Int(return type){
	    a : Int -> a + 1;
}

fun hello(a : Int, b : Int, lambdafun : (Int) -> Int){
	System.out.println(lambda(a+b))
}


Avoid using multiple labeled returns in a lambda. Consider restructuring the lambda so that it will have a single exit point. If that's not possible or not clear enough, consider converting the lambda into an anonymous function.

Do not use a labeled return for the last statement in a lambda


Higher Order Functions :

Those functions which can be passed as parameters, accepts fun as parameter, return fun as parameter



Exception Handling : (all inherit the throwable class)

try: try block contains set of statements which might generate an exception. It must be followed by either catch or finally or both.

catch: catch block is used to catch the exception thrown from try block.

finally: finally block always execute whether exception is handled or not. So it is used to execute important code statement.

throw: throw keyword is used to throw an exception explicitly.

after try u shld have either catch or finally (but someone out of the two shld be there)

try {
        val data = 20 / 0  //may throw exception

    }
    catch (e: ArithmeticException) {
        println(e)
    }


multiple catch :

one way :

try{

}
catch(e : NumberFormatEXception){   // most specific to generalized; if u write the other way it will give warning but will be executed

}
catch(e : IndexOutofBound){

}
catch(e : Exception){

}


second way :

try {
    // do some work
} catch (ex: Exception) {
    when(ex) {
        is IllegalAccessException, is IndexOutOfBoundsException -> {
            // handle those above
        }
        else -> throw ex
    }
}


// Finally block

 try {
        val data = 5 / 0                       // here finally will compulsory get executed
        println(data)                           // as the exception is not matched so the code will terminate and the last print statment will only be executed if
    } catch (e: NullPointerException) {         //exception matches i.e. Arithmetic Exception
        println(e)
    } finally {
        println("finally block always executes")
    }
    println("below codes...")
}



Immutability :

prefer to use immutable variables to mutable ones
Like using local variables as val if they are not going to be modified
Collections like list, map ,set -> immutable use them if values are not going to change

Eg : 	// Bad: arrayListOf() returns ArrayList<T>, which is a mutable collection type
		val allowedValues = arrayListOf("a", "b", "c")

		// Good: listOf() returns List<T>
		val allowedValues = listOf("a", "b", "c")


Type aliases﻿:

If you have a functional type or a type with type parameters which is used multiple times in a codebase, prefer defining a type alias for it:

typealias MouseClickHandler = (Any, MouseEvent) -> Unit
typealias PersonIndex = Map<String, Person>


TrimIndent :

common minimal indent of all input lines is detected first and then that minimum common is removed. Blank lines are also removed only if they appear before or after


Eg :

val withoutIndent =
        """
   ABC
            123

            456

        """.trimIndent()


val withoutIndent =
        """
   ABC
            123
            456

        """.trimIndent()

val withoutIndent =
        """
            ABC
            123
            456

        """.trimIndent()


Trim Margin :

Trims leading whitespace characters followed by marginPrefix from every line of a source string and removes the first and the last lines if they are blank (notice difference blank vs empty).

Doesn't affect a line if it doesn't contain marginPrefix except the first and the last blank lines.



Type Checks : is and !is

if (obj is String) {
    print(obj.length)
}

if (obj !is String) { // same as !(obj is String)
    print("Not a String")
} else {
    print(obj.length)
}

Whenever 'is' is used the compiler tracks the 'is' usage inside the code and accordingly smart casts the values

when (x) {
    is Int -> print(x + 1)         // in print statement x is auto casted to Int
    is String -> print(x.length + 1)
    is IntArray -> print(x.sum())
}



Class and Object :

primary constructor -> only in the heade; can have arguments also

class properties  -> declared inside the class header

inti block -> all the initialization take places here as u cannot initialize inside the primary constructor


// if no constructor declared auto generated primary constructor

class InitOrderDemo(name: String,val ans1 : String, val ans2 : Int) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }

    constructor(ans2 : Int): this("hello2","yes2",4){
        println("$ans2")
    }

}
fun main() {
    InitOrderDemo("hello","yes",3)
    InitOrderDemo(4) // initializer blocks are part of primary constructor so they are executed always before the secondary constructor
}


class Constructors {    // even if no primary constructor still inti block is executed and then secondary constructor is executed
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor $i")
    }
}
fun main() {
    Constructors(1)
}

class Constructors {    // even if no primary constructor still inti block is executed always
    init {
        println("Init block")
    }
}
fun main() {
    Constructors()

    //val invoice = Invoice()   - object declaration(no new keyword)

    //val customer = Customer("Joe Smith")
}



Abstract Classes :

some or all members can be abstract

abstract class Polygon {
    abstract fun draw()
}

class Rectangle : Polygon() {
    override fun draw() {
        // draw the rectangle
    }
}


Inheritance :

Any -> Base class of all classes
hashCode(), equals(),toString() -> functions in Any class

All classes are 'final' by default  -> so cannot be inherited
Why ?  -> fragile base classes in java coz then if base class is changed the child classes may get affected/malfunction. So better to keep them final until u have to inherit it.
open -> keyword used for making them inheritable


Overiding Methods and Properties :

Only 'open' functions or properties can be overriden

not allowed to extend multiple superclasses in Kotlin (multiple inheritance)



Properties in Classes :

var type -> both getter and setter
val type -> only getter
you can override the geter and setters

var stringRepresentation: String
    get() = this.toString()
    set(value) {
        setDataFromString(value) // parses the string and assigns values to other properties
    }


By keyword :

when using by keyword, you are stating that this getter/getter&setter is provided elsewhere (i.e. it's been delegated). It's provided by the function that comes after by.

 It’s simply a means of code-sharing that helps you adhere to the DRY (Don’t Repeat Yourself) good coding practice.


Delegates :

common code if want to use by all properties, delegate those properties using 'by'

Lazy delegate :

observable delegate : two parameters; an initial value and a lambda. The lambda will be executed each time the value of the field is changed.

                      var maxCount: Int by observable(initialValue = 0) { property, oldValue, newValue ->
   																		println("${property.name} is being changed from $oldValue to $newValue")
																		}

					  fun main() {
									    maxCount++
									    maxCount++
									    maxCount += 10
									}

									> maxCount is being changed from 0 to 1
									> maxCount is being changed from 1 to 2
									> maxCount is being changed from 2 to 12

vetoable delegate :   lambda parameter for vetoable must return a Boolean (rest same as observable)

notnull delegate :  It works similar to lateinit in that it will throw an IllegalStateException if a variable is accessed before it is initialized.




















/* Online Kotlin Compiler */
fun main() {
    println("Hello, World!")
    var hello = "hello"
    println(hello)

    var nullCheck : String?    // if did not initialize it gives error
    nullCheck = null
    println(nullCheck + " hello")

    //var nullcheck;   // error nullcheck must be initlized
    //println(nullcheck)

    var nullcheck1 : Int  // only give warning that it is not initialized
    //println(nullcheck1)      // but when u use it will give error

    var array1 = Array(3,{i->i+9})
    println(array1[0])
    println(array1[1])
    println(array1[2])

    var array2 = arrayOf(1,2,3,4)
    println(array2[0])
    println(array2[1])
    println(array2[2])
    println(array2[3])


    //val reader = Scanner(System.`in`)
    //var integer = reader.nextInt()
    var variable: String = if(0 > 10){
        "variable greater than 10"
    }else if(51 < 10){
        "variable less than 10"
    }else{
        "variable equal to 10"
    }

    when(25) {
        in 1..5 -> println("Input is provided in the range 1 to 5")
        in 6..10 -> println("Input is provided in the range 6 to 10")
        //else -> println("none of the above")
    }

    when("Hllo"){
        "hello" -> println("Say hello")
        "Hello" -> println("Say Hello")
    }

    println("helooooo $variable")

    var inputString : String? = readLine()
    var inputInt : Int = Integer.valueOf(readLine()!!)

    println(inputString)
    println(inputInt)

    loop1@ for(i in 0..5){
        loop2@ for(j in 0 ..3){
            if(i < j){
                break@loop1
            }else if(i == j){
                break@loop2
            }
            println("$i and $j")
        }
    }

    fun hello(a : Int = 3, b : Int = 1){
        println(a+b)
    }

    hello()   // default value taken
    hello(4)  // taken b as deafault value
    hello(b=6) // a has default now and b has 6

    val lambdafun : (Int) -> Unit = {
        a:Int -> println("Inside" + a)   // return type for println is Unit -> equal to void type in java or return of any statement like print
    }

    lambdafun(3)

    val lambdafun1 : (String,String) -> String = {
        string1 : String, string2 : String -> string1 + string2
    }

    var result : String = lambdafun1("yes", "no")
    println(result)

    val lambdafun2 : (Int, Int) -> Int = {
        a : Int, b : Int;
        var c : Int = a + b;
        -> c
    }

    var result2 : Int = lambdafun2(3,4)
    println(result2)


    // higher order functions

    fun Cloth(fiber:(String) -> String):Unit{
         var result = fiber("Cotton")
         print(result)
    }

    val fiber : (String) -> String = {f : String -> "f fiber"}
    Cloth(fiber)


    //try catch block as an expression
	fun TryCatchExp(s : String) : Int{
        return try{
            Integer.parseInt(s)
        }
        catch(e : NumberFormatException){
            -1
        }
    }

	fun main() {
    	println("Hello, World!")
    	var result = TryCatchExp("10")
    	println(result)
    	var result1 = TryCatchExp("10.5")   //exception for all below
    	println(result1)
    	var result2 = TryCatchExp("e")
    	println(result2)
    	var result3 = TryCatchExp("efg")
    	println(result3)
    	var result4 = TryCatchExp(" ")
    	println(result4)

	}

}




     */

}