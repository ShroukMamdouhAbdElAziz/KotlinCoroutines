package com.example.kotlincoroutines.chapter3

/* Coroutine cancellation
---------------------------
   Cancellation , Timeouts and  how to handle cancellation Exception in coroutine

   Why would you cancel a coroutine?
   ----------------------------------
    for several reasons:
    ====================
     1.in case where you no longer need the result from the coroutine
     2. in case coroutine is taking too long to perform the task, then you can cancel it and
         find another way to execute the same task.
     3. for any  reason
 ------------------------------------------------------------------------------------
  To cancel the coroutine , the coroutine has to be cooperative( cancellable)
                                               ===================

  ex:
     val job = launch{
       //  the code has to be cooperative in order to get cancelled

     }

     job.cancel() // if the coroutine is cooperative then cancel it.and if not, it will not get cancelled.
     job.join()   // waits for the coroutine to finish .


     Note:There is a function which is a a combination between cancel() and join() -> job.cancelAndjoin()
                                                                                      ===================

     // if the coroutine is cooperative then cancel it ,else , if it is not cooperative
     then wait for the coroutine to finish

     cancelAndJoin()

   -------------------------------------------------------------------------------------------------------------

   what makes a coroutine cooperative?? / what we mean by cooperative?
   ===================================================================
     There are 2 ways to make coroutine Cooperative:
     ----------------------------------------------
     1. Periodically invoke a suspending function that checks for cancellation and
       only those suspending functions that belongs to kotlinx.coroutines package will make a coroutine cooperative.

       ex: delay(),yield(), withContext(), withTimeOut() ... are the suspending functions that belongs to
           kotlinx.coroutine package which making coroutine cancellable


           yield() -> if you donot want a coroutine to a delay
                   -> yield() is a cancelable in major also it doesn't delay your coroutine
                   -> let the coroutine execute very fast


    2.Explicity check for the cancellation status within the coroutine
                  -> CoroutineScope.isActive  boolean flag
                  -> when the coroutine is active then the flag is true
                                           =====                   =====
                  -> when the coroutine is cancelled then the flag is false
                                          ============                ======
                       using the false value of the flag, we can terminate the coroutine internally                      =========                  =====
                            =============                      =========               ===========
                       Noting that : in case of Threads donot have such in built mechanism to cancel itself internally.
                       =============
                       so we are glad that in case of coroutine , we have got a provision for terminating
                       a coroutine based on a boolean flag ( Another advantage of coroutine over Threads).
                                                          ------------------------------------------------



*/