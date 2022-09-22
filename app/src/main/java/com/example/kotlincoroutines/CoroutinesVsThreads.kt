package com.example.kotlincoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main(){  // main Function Executes in the Main Thread

    println("Main Program starts :${Thread.currentThread().name}")

// replace Thread example with Coroutines
// creating a background coroutine that runs on a background thread

    GlobalScope.launch {  //thread:T1

        println("Fake work starts: ${Thread.currentThread().name}") //thread:T1


       // Thread.sleep(1000)  // pretending doing some work ...maybe file upload
       delay(1000) // coroutines is suspended but thread:T1 is free( not blocked)

        println("Fake work ends: ${Thread.currentThread().name}") //Either thread:T1 or some other thread
    }

    /*Blocks the current main thread & wait for coroutine to finish ( practically not a right way to wait)
     as it is impossible know the time needed for the coroutine task to be completed
      so this statement  Thread.sleep(2000) is useless for a real project */

  //  Thread.sleep(2000)
   // delay(2000) -> delay is a suspended fun and are only allowed to be called from a coroutines
    //   or from another suspending function.So we can call it inside runBlocking

    runBlocking { // creates a coroutine that blocks the current main thread here
        delay(2000) // wait for our previous coroutines to finish its task,practically it is not a right way to wait
    }

    println("Main Program ends :${Thread.currentThread().name}")

}

// Summary
/*
 Noting that the output here is
   Main Program starts :main
   Main Program ends :main

   without any pretend signs of the code in the coroutines Block As:
     Unline threads , for coroutines the application by default doesn't wait for it to finish its execution .
     ======================================================================================================

     So, in order to let the application wait the coroutines until finish its work , we need to do that Manually
     ---------------------------------------------------------------------------------------------------------
     like added this  , Thread.sleep()

     but noting that:
     ===================

     /*  Thread.sleep() ,Blocks the current main thread & wait for coroutine to finish ( practically not a right way to wait)
     as it is impossible know the time needed for the coroutine task to be completed
      so this statement  Thread.sleep(2000) is useless for a real project */


      what is the difference between thread.sleep() function and delay() :
     ========================================================================

      /*using Thread.sleep inside the Coroutines , will block the entire thread ,
         so if other coroutines are operated inside the same thread , this will block the other coroutines as well
        and this violate the principle of coroutines.

        so , instead of using thread.sleep () , we use delay() inside coroutines
        without blocking the entire thread

        delay(1000) will suspend the coroutines for 1 sec but it is not block the thread at all (which mean
        the execution of other coroutines will not be affected) */

        -----------------------------------------------------------------------------------------
        These Two functions : launch{} and runBlocking{} Creating coroutines
        --------------------------------------------------------------------
        GlobalScope.launch{} -> in this example  this launch fun creates a coroutines that doesn't block the main thread.
        but this runBlocking{} -> creates a coroutine that blocks the main thread here/
 */




