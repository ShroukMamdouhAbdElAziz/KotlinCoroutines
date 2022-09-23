package com.example.kotlincoroutines.chapter2

import kotlinx.coroutines.*

/* what is the practical use of runBlocking Function ?
-------------------------------------------------------
 is generally used to write test cases to test suspended functions.

*/

fun main(){

    runBlocking { // create a coroutine that blocks the current main Thread

        println("Main Program starts :${Thread.currentThread().name}")// main thread


        val jobDeferred: Deferred<Int> =  GlobalScope.async {  // thraed T1
            println("Fake work starts: ${Thread.currentThread().name}") // thraed T1

            delay(1000) // coroutines is suspended but main thread is free( not blocked)


            println("Fake work ends: ${Thread.currentThread().name}") //Either // thraed T1 or some other thread
            15  // value we need to be returned from the lambda expression
        }

        jobDeferred.join() //main thread , wait for our previous coroutines to finish its task
        val num:Int = jobDeferred.await() // await() , if we want to use the returned value from the lambda expression

        println("Main Program ends :${Thread.currentThread().name}") // main thread

    }
}

// the fun we need to test it
suspend fun myOwnSuspendingFunc(){
    delay(1000)
}