package com.example.kotlincoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/* Completing on CoroutinesVSThreads*/

fun main() {  // main Function Executes in the Main Thread

    runBlocking { // create a coroutine that blocks the current main Thread

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

    }
}

// You can create you own suspended fun
//Remember The suspending functions (ex: delay()) are only allowed to be called from a coroutines
//   or from another suspending function.

suspend fun mySuspendedFunc(time:Long){

    delay(time)
}