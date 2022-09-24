package com.example.kotlincoroutines.chapter3

import kotlinx.coroutines.*

/* Handling coroutine cancellation Exception:
-----------------------------------------------
1.  any cancellable suspending functions in this package(kotlinx.coroutines) such as yield() ,delay() ...throw
      cancellationException when the coroutine is cancelled.( using try and catch Exception)

2. you canot execute a suspending function from the finally block because the coroutine running this code
    is already cancelled

3. if you want to execute a suspending function from a finally block ,
     then wrap the code within withContext(non cancellable) function.

4. withContext() is a coroutine builder , just like launch creates another coroutine, in a new background thread.

5.you can cancel your own cancellation message using
      job.cancel(CancellationException("My crash message"))
 */

/*fun main()= runBlocking {

    println("Main Program starts :${Thread.currentThread().name}") // main

    val job: Job = launch(Dispatchers.Default) { // thread T1 : creates a non blocking coroutine
     try {

         for (i in 0..500){
             println("$i")
             delay(5)
         }

     }catch (ex:CancellationException) {
         println("Exception caught safely")
     } finally {
         println("close resources in finally")
     }

    }

    delay(10)  // let's print a few values before coroutine get cancelled
    //job.cancel()

    // job.join() // wait for coroutine to finish

    // instead of them use job.cancelAndjoin()
    job.cancelAndJoin()
    println("main program ends:${Thread.currentThread().name}") // main
}*/

/*3. if you want to execute a suspending function from a finally block ,
then wrap the code within withContext(non cancellable) function.*/

fun main() = runBlocking {

    println("Main Program starts :${Thread.currentThread().name}") // main

    val job: Job = launch(Dispatchers.Default) { // thread T1 : creates a non blocking coroutine
        try {

            for (i in 0..500) {
                println("$i")
                delay(5)
            }

        } catch (ex: CancellationException) {
            println("Exception caught safely:${ex.message}")
        } finally {
/*3. if you want to execute a suspending function from a finally block ,
then wrap the code within withContext(non cancellable) function.*/
            withContext(NonCancellable) {
                delay(1000)  // usually we donot use suspending fun in finally
                println("close resources in finally")
            }
        }
    }

    delay(10)  // let's print a few values before coroutine get cancelled

    job.cancel(CancellationException("my own crash message"))

    job.join()

    println("main program ends:${Thread.currentThread().name}") // main
}
