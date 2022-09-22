package com.example.kotlincoroutines.chapter2

import kotlinx.coroutines.*

fun main(){

  /*  runBlocking { // create a coroutine that blocks the current main Thread

        println("Main Program starts :${Thread.currentThread().name}")// main thread


        val jobDeferred: Deferred<Int> =  async {  //Main thread as async() scope is within the scope of runBlocking which is here Main Thread

            println("Fake work starts: ${Thread.currentThread().name}") //Main Thread

            delay(1000) // coroutines is suspended but main thread is free( not blocked)


            println("Fake work ends: ${Thread.currentThread().name}") //Either main thread or some other thread
            15  // value we need to be returned from the lambda expression
        }

        jobDeferred.join() //main thread , wait for our previous coroutines to finish its task,practically it is not a right way to wait
       val num:Int = jobDeferred.await() // await() , if we want to use the returned value from the lambda expression

        println("Main Program ends :${Thread.currentThread().name}") // main thread

    }*/

    // using GlobalScope.async

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

     /* Async Coroutine Builder
    =============================

     launches a new coroutine without blocking the current thread.
           also this coroutine inherits the thread & coroutine scope from the immediate parent coroutine.

    return a reference of Deferred Object which is a subclass of Job Object.
    -------------------------------------------------------------------------
   - Deferred is of Generic Type and we can put the type according the return we expexted from the lambda Expression
    ( the last statement in lambda expression).

    - using deferredObject : you can cancel the coroutine, wait for the coroutine to finish , or retieve the returned
      value ( by using deferredObject.await().

      ex:
       ==jobDeferred.join() // wait for our previous coroutines to finish its task,practically it is not a right way to wait
       == jobDeferred.await() // await() , if we want to use the returned value from the lambda expression.


    Noting that : await() and join() are suspended functions , so we can use them inside the coroutine block
    */
}