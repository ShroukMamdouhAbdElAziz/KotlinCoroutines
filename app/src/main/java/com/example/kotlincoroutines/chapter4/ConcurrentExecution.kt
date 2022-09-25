package com.example.kotlincoroutines.chapter4

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


// concurrent( parallel execution)
/* by wrapping these two functions getMessageOne() , getMessageTwo() within async or launch coroutine builders */

/*fun main()= runBlocking { // create a blocking coroutine that executes in current thread (main)

    println("Main program starts ${Thread.currentThread().name}") // main thread

    // this function to measure the time taking by this code to execute
    //1. achieving concurrent execution using async coroutine builder
    val time = measureTimeMillis {
        val msgOne: Deferred<String> =async { getMessageOne() } // create separate background coroutine
        val msgTwo:Deferred<String> = async { getMessageTwo() } //create another separate background coroutine in parallel to prev one

        println("the entire msg is ${msgOne.await() + msgTwo.await()}")
    }

    println("completed in $time ms")
    println("Main program ends ${Thread.currentThread().name}")  // main thread
}*/

//2. achieving concurrent execution using launch coroutine builder
fun main()= runBlocking { // create a blocking coroutine that executes in current thread (main)

    println("Main program starts ${Thread.currentThread().name}") // main thread

    // this function to measure the time taking by this code to execute

    val time = measureTimeMillis {
        launch { getMessageOne() } // create separate background coroutine
        launch { getMessageTwo() } //create another separate background coroutine in parallel to prev one


    }

    println("completed in $time ms")
    println("Main program ends ${Thread.currentThread().name}")  // main thread
}