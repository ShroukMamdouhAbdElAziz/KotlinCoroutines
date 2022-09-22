package com.example.kotlincoroutines.chapter2

import kotlinx.coroutines.*

fun main() {  // main Function Executes in the Main Thread

   /* runBlocking { // create a coroutine that blocks the current main Thread

        println("Main Program starts :${Thread.currentThread().name}")// main thread


        GlobalScope.launch {  //thread:T1

            println("Fake work starts: ${Thread.currentThread().name}") //thread:T1

            delay(1000) // coroutines is suspended but thread:T1 is free( not blocked)
            // or mySuspendedFunc(2000)

            println("Fake work ends: ${Thread.currentThread().name}") //Either thread:T1 or some other thread
        }

        delay(2000) //main thread , wait for our previous coroutines to finish its task,practically it is not a right way to wait
        // or mySuspendedFunc(2000)

        println("Main Program ends :${Thread.currentThread().name}") // main thread

    }*/

    runBlocking { // create a coroutine that blocks the current main Thread

        println("Main Program starts :${Thread.currentThread().name}")// main thread


     val job:Job =  launch {  //Main thread as launch() scope is within the scope of runBlocking which is here Main Thread

            println("Fake work starts: ${Thread.currentThread().name}") //Main Thread

            delay(1000) // coroutines is suspended but main thread is free( not blocked)
            // or mySuspendedFunc(2000)

            println("Fake work ends: ${Thread.currentThread().name}") //Either main thread or some other thread
        }

        job.join() //main thread , wait for our previous coroutines to finish its task,practically it is not a right way to wait
        // or mySuspendedFunc(2000)

        println("Main Program ends :${Thread.currentThread().name}") // main thread

    }

    /* launch
    =============
   Launches a new coroutine without blocking the current thread .

        -and this function returns a reference to the coroutine as a Job.

        -The coroutine is cancelled when the resulting job is cancelled.

     This Job Object : Using this Job Object you can control this coroutine .So as mentioned before using delay()
     is not the best practice here to to wait the coroutine until finish its work .
     so instead of delay(), we can use job.join()

     - this join() fun will wait for the coroutine to finish its execution.
     ================
        */
}