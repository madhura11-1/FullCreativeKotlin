package com.example.myapplication

import kotlinx.coroutines.*

class Coroutines {

  /*
    //Couroutine Builder : They are used to build an coroutine

    Launch :   Global.launch{ to run coroutine for entire life of the app
                              eg : Play music in background, download a file at start
                              Mostly discouraged to use as if u forget abt it then it will keep running in background as consume memory
                                  }
               launch{ to run coroutine for only that activity life
                        eg : Normal things }



     Async :   Global.async()
               async()
               Same as Launch but it returns the Deferred obj which is generalized (meaning we can return some data types from the async)
               (from coroutines u can return smtg but from threads you cannot return)


     Runblocking :

     cancel a coroutine :

     U can only cancel when the coroutine is cooperative
     if it is not cooperative then, the program will wait fro the coroutine to finish first and then the program will end


    Cooperative Functions : delay(), yield(), withContext(), withTimeout()

    Coroutines can be made cooperative with isActive() : function also
    It checks if the cancel statment is called and id it is called Active flag is made false

    Suspeding Functions :  care those called from coroutines

    aLl the functions are executed in sequence in coroutines (we can make them concurrent)


    Dispatchers : Dispatchers decide the thread of the coroutines
                  Types : Default
                          Unconfined
                          Main
                          IO

    fun main() = runBlocking {

    // this: CoroutineScope instance
    // coroutineContext: CoroutineContext instance

    /* Without Parameter: CONFINED      [CONFINED DISPATCHER]
        - Inherits CoroutineContext from immediate parent coroutine.
        - Even after delay() or suspending function, it continues to run in the same thread.  */
    launch {
        println("C1: ${Thread.currentThread().name}")       // Thread: main
        delay(1000)
        println("C1 after delay: ${Thread.currentThread().name}")   // Thread: main
    }

    /* With parameter: Dispatchers.Default [similar to GlobalScope.launch { } ]
        - Gets its own context at Global level. Executes in a separate background thread.
        - After delay() or suspending function execution,
            it continues to run either in the same thread or some other thread.  */
    launch(Dispatchers.Default) {
        println("C2: ${Thread.currentThread().name}")   // Thread: T1
        delay(1000)
        println("C2 after delay: ${Thread.currentThread().name}")   // Thread: Either T1 or some other thread
    }

    /*  With parameter: Dispatchers.Unconfined      [UNCONFINED DISPATCHER]
        - Inherits CoroutineContext from the immediate parent coroutine.
        - After delay() or suspending function execution, it continues to run in some other thread.  */
    launch(Dispatchers.Unconfined) {
        println("C3: ${Thread.currentThread().name}")   // Thread: main
        delay(1000)
        println("C3 after delay: ${Thread.currentThread().name}")   // Thread: some other thread T1
    }

    launch(coroutineContext) {
        println("C4: ${Thread.currentThread().name}")       // Thread: main
        delay(1000)
        println("C4 after delay: ${Thread.currentThread().name}")   // Thread: main
    }

    println("...Main Program...")
}

   */



}

fun main(){


    runBlocking{             //blocks the main thread until all the coroutines finish their work

        println("Start")

        var job : Job = launch {          // this launch inside runblocking inherits the thread of runblocking (eg: if runblocking on T1 then launch also in T1)
            println("Inside coroutine")
            delay(1000)
            println("Inside after delay")
        }

        var deferredjob : Deferred<Int>  = async {   // Deferred obj is subclass of the Job only just it has extra functions
                                                     // it helps to cancel, wait for coroutine and even return smtg from coroutien

            println("In the async coroutine")
            15
        }

        var job1 : Job = launch {          // this launch inside runblocking inherits the thread of runblocking (eg: if runblocking on T1 then launch also in T1)
            println("Inside coroutine 1")
            for(i in 0..20){
                println("$i")
                delay(100)     // this delay() function comes under cooperative so if this is not there then the job1 will not get cancelled
            }

            println("Inside after delay 1")
        }

        delay(1000)
        job1.cancelAndJoin()

      //  delay(2000)
       /* output with delay :  Start
                             End
                             Inside coroutine
                             Inside after delay */

        job.join()    // here the main thread will wait until the job of coroutine is done it will

        var integer = deferredjob.await() // here also main thread waits for this coroutine
        println("$integer")
        println("End")
    }

}