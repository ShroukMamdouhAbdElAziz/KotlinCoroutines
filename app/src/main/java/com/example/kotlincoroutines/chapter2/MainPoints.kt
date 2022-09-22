package com.example.kotlincoroutines.chapter2

/* Includes:
--------------

    Coroutine Builders.( launch , runBlocking and async)

    What exactly are coroutine Builders?
    --------------------------------------
    are Functions used for creating Coroutines .

    What are the different types of coroutine Builders?
    ----------------------------------------------------

  1.   launch()
     GlobalScope.launch{} ->GlobalScope is a companion Object

  2.   async
     GlobalScope.async{}

  3.   runBlocking


  what is the significant of using the companion Object GlobalScope with launch{}
  -------------------------------------------------------------------------------
 At the beginning note that
 ============================
   you  have a LoginScreen and you have a coroutine inside it using launch{}, this launch fun create a coroutine in the LOCAL scope
   and navigate from loginScreen to home
   Screen which have coroutine inside it .

   and when you navigated back from Homescreen to the previous screen (Login screen), the homescreen will be destroyed
   and hence the coroutine will be canceled .( if the lifeTime of the screen is over , then coroutine inside this
   screen is over).

   So, What about using GlobalScope with launch{}
   ================================================
   GlobalScope.launch{} -> // create coroutines at global(app) level.

   Global Coroutines are Top-Level coroutines and it can survive the entire life of the application.so even
   all the local scopes are destroyed , then also the global coroutine no matter from from which local scope it was
   launched. it can survive the entire life of the app.


   When should you launch coroutine Globally and when should launch coroutine locally
   -------------------------------------------------------------------------------------

   1. You can use GlobalScope( create coroutine at global(App) level),

    ===================================================================
    in cases where you donot depend on the local scopes.such as , once you click on a button to download a file
    , then it can run in the global scope and let it complete in the background.Because
    Generally the downloaded file is not needed during your ongoing activities in your application.
    just start your downloaded operation and move on with your other work.

    tHe same is the case of playing music, just start playing the music and it has nothing
    to do with your other ongoing task.

     GlobalScope.launch{
       ex : download file
       ex: play music
     }

   2. You can create coroutine at local scope
   ===========================================

   when you want to compute some values within alocal scope and end it there only.
   or you can do some login , and you need to end that login operation right there

   launch{}


   Highly note that
   ====================
   also note that using GlobalScope.launch is highly discouraged , only use it when it is needed.
   Because , if you create a coroutine globally and you forget about it , then it will keep running
   in the background and consume a lot of memory.which is not good actually.
   so you need to use a global coroutine very very carefully.

          IN Short : using LAUNCH function should be your default choice.


          ex:

          launch{
            // some data computation
            //Login Operation
          }


    1. launch
    =============
   Launches a new coroutine without blocking the current thread .

        -and this function returns a reference to the coroutine as a Job.

        -The coroutine is cancelled when the resulting job is cancelled.

     This Job Object :
     =====================
     Using this Job Object you can control this coroutine .So as mentioned before using delay()
     is not the best practice here to to wait the coroutine until finish its work .
     so instead of delay(), we can use job.join()

     - this join() fun will wait for the coroutine to finish its execution.
     - using job.cancel() - > you can cancel the coroutine

     Summarize launch{}
     ==================
     'launch{}' -> coroutine builder( fire and forget coroutine builder).
          launches a new coroutine without blocking the current thread.
           also this coroutine inherits the thread & coroutine scope from the immediate parent coroutine.

     This fun : returns a reference to job object.
     Using this job Object , you can cancel the coroutine or wait for coroutine to finish.
     Hence , this job Object allows you to controll the coroutine.

 */