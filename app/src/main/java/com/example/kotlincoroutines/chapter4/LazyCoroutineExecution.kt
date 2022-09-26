package com.example.kotlincoroutines.chapter4

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


/* Lazy coroutine execution
----------------------------
   * lazily start a coroutine using : async ()
   * lazily execute code in coroutine.
   * we can make our coroutine execute only if we use the result only( msgOne and msgTwo) in the program by
     using the parameter start=CoroutineStart.LAZY
*/

fun main()= runBlocking { // create a blocking coroutine that executes in current thread (main)

    println("Main program starts ${Thread.currentThread().name}") // main thread

// we can make our coroutine execute only if we use the result only( msgOne and msgTwo) in the program by
// using the parameter start=CoroutineStart.LAZY

        val msgOne =async(start= CoroutineStart.LAZY) { getMessageOneFun() }
        val msgTwo = async(start=CoroutineStart.LAZY) {getMessageTwoFun()  }

    // so the coroutine will be executed once , we will use the result only msgOne.await() + msgTwo.await()

      println("the entire msg is ${msgOne.await() + msgTwo.await()}")

    println("Main program ends ${Thread.currentThread().name}")  // main thread
}

suspend fun getMessageOneFun():String {
    delay(1000) // pretend to do some work.
    println("After working in getMessageOne")
    return "Hello"
}

suspend fun getMessageTwoFun():String {
    delay(1000) // pretend to do some work.
    println("After working in getMessageTwo")
    return "World"
}




