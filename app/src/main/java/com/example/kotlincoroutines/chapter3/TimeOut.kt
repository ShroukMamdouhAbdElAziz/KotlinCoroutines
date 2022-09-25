package com.example.kotlincoroutines.chapter3

import kotlinx.coroutines.*

/* Timeouts
  ---------
  suppose you launch a coroutine that is taking more time than expected to finish its work.
  Then , in this case , you can cancel your coroutine.

  And for time-bounded task, kotlin provides us with special functions ,such as withTimeout() function ,withTimeoutOrNull().

 -----------------------------------------------------------------------------------------------------------------
 These Two Functions (withTimeout() ,withTimeoutOrNull() )
 ============================================================
  are basically coroutine builders.They also create coroutines.

  The diff betweeb them
  ----------------.----
  withTimeout() -> throw timeOutCancellationException
                // if it is not finished in this time ,TimeoutCancellationException will be thrown
               // so use try catch blocks to handle the exception .

  withTimeoutOrNull -> doen't thrown TimeoutCancellationException .
                    -> this function returns a value at the end from the coroutine , if the oroutine task executed at
                       its time otherwise the result will be null


 */

/*fun main()= runBlocking{

    println("Main program starts ${Thread.currentThread().name}")

    withTimeout(2000){  // write the time expected for a coroutine to finish its task ,
        // if it is not finished in this time ,TimeoutCancellationException will be thrown
        // so use try catch blocks to handle the exception

        try {
            for (i in 0..500){
                println(i)
                delay(500)
            }
        }catch (ex:TimeoutCancellationException){
            println("Exception caught safely:${ex.message}")
        }

    }*/

fun main()= runBlocking{

    println("Main program starts ${Thread.currentThread().name}")
// return the result ( lambda statement ) as its executed on time
  /* var result:String?= withTimeoutOrNull(2000){
        for (i in 0..2){
            println(i)
            delay(500)
        }
        "Hello"
    }*/


    // return null as the task not executed on time
    var result:String?= withTimeoutOrNull(2000){
        for (i in 0..100){
            println(i)
            delay(500)
        }
        "Hello"
    }

    println("Result : ${result}")


}