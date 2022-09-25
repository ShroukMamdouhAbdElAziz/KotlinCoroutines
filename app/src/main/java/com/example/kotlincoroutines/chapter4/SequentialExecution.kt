package com.example.kotlincoroutines.chapter4

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main()= runBlocking { // create a blocking coroutine that executes in current thread (main)

    println("Main program starts ${Thread.currentThread().name}") // main thread

    // this function to measure the time taking by this code to execute
    val time = measureTimeMillis {
        val msgOne = getMessageOne()
        val msgTwo = getMessageTwo()

        println("the entire msg is ${msgOne + msgTwo}")
    }

    println("completed in $time ms")
    println("Main program ends ${Thread.currentThread().name}")  // main thread
}


    suspend fun getMessageOne():String {
        delay(1000) // pretend to do some work
        return "Hello"
    }

    suspend fun getMessageTwo():String {
        delay(1000) // pretend to do some work
        return "World"
    }
