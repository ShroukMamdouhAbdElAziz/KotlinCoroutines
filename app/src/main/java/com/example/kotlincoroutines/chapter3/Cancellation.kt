package com.example.kotlincoroutines.chapter3

import kotlinx.coroutines.*


// using suspending functions

/*fun main()= runBlocking {

    println("Main Program starts :${Thread.currentThread().name}") // main

    val job: Job = launch { // thread T1 : creates a non blocking coroutine
        for (i in 0..500){
            println("$i")
           // delay(50)   // delay is a suspended cancelable fun it willl check if there is job.cancel() to cancal the entire coroutine

            yield()
        }

    }

    delay(10)  // let's print a few values before coroutine get cancelled
    //job.cancel()

   // job.join() // wait for coroutine to finish

    // instead of them use job.cancelAndjoin()
    job.cancelAndJoin()
    println("main program ends:${Thread.currentThread().name}") // main
}*/

// check the cancellation status

fun main()= runBlocking {

    println("Main Program starts :${Thread.currentThread().name}") // main

    val job: Job = launch(Dispatchers.Default) { // thread T1 : creates a non blocking coroutine
        for (i in 0..500){

            if(!isActive){
               // break
                return@launch   // terminating the coroutine and retun to launch() level
            }
            println("$i")
            Thread.sleep(1)
        }

    }

    delay(10)  // let's print a few values before coroutine get cancelled
    //job.cancel()

    // job.join() // wait for coroutine to finish

    // instead of them use job.cancelAndjoin()
    job.cancelAndJoin()
    println("main program ends:${Thread.currentThread().name}") // main
}