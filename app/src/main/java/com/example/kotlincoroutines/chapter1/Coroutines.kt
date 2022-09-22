package com.example.kotlincoroutines.chapter1

/* note:
============
First understand How exactly your application works, when the user launches your application
 -------------------------------------------------------------------------------------------
 1- when the user launches the application ,by default the Main thread is created.
        (Noting that  Main Thread is the life of your application).

 2-what are the purpose of having Main Thread?
  --------------------------------------------
   is to perform some operations and these operations are very small(light weight operations) like :
      *UI interactions.
      *Button Click.
      *Mathematical operations.
      *Small logical Operations.
  Hence , On Main Thread we Perform Small Operations.

------------------------------------------------------------------------------------------------------------------------------------------------------
3-What about the Long and Heavy Operations ?
-------------------------------------------
 *like(long Operations, File download from the server ,Network Operations ,loading and displaying an Image ,
        heavy some database Queries) .
 * If you tried to perform these operations on the Main Thread , The main Thread will be blocked hence,
        the application will be freezed ( app will be hanged).
 *If the Main Thread still freezed for 5 secs or more ,You will get ANR ( application not responding)
        with Crash message.
    ---------------
     The Solutions
     --------------
 Solution   1# Instead of using Main Thread for these Operations,
              we need to use worker or background Thread for EACH Operation to run the Heavy operations. like :
 --------------------------------------------------------------------------------------------------------------------------------------------------------
       Background Thread 1 :For Network Operations.
       Background Thread 2 :For File Download.
       Background Thread 3:For Image Loading.
       Background Thread 4:For DataBase Queries.

 ### But Noting that there is a LIMIT of How Many BackGround THreads you can Create at a time in your App.
      Because creating thread is very very Expensive.

 and if you create more and more threads ,Then there will be a time of (Out of Memory) when your device is run ,
 and your application will be shutdown with ANR (crash)message.

 So creating so many background threads is a bad Solution.


 Solution 2# Coroutines
 --------------------------
 When you use coroutines , you don't have to create so many threads for each operations.
 INSTEAD you can just have ONE background thread

 and on this background thread , you can launch coroutines inside it like :
          * launch a coroutine 1 -> for file upload
          *launch coroutine 2 -> on THE SAME BACKGROUND THREAD to perform some network operations.
          *launch coroutine 3 -> on THE SAME BACKGROUND THREAD to perform some database queries.
          *launch coroutine 4 -> on THE SAME BACKGROUND THREAD to load image.
          *launch coroutine 5 -> on THE SAME BACKGROUND THREAD to download file.

  SHORTLY :
  +++++++++with Memory Consumption one background thread , can perform so many heavy operations
                               (this is what coroutine Does)
======================================================================================================================

How would we Define Coroutines:
================================
 - Light weight Threads
 -Similar to Threads , coroutines can run in parallel , wait for each other to finish,
  and even Multiple coroutines can communicate with each other.


 - BUT REMEMBER coroutine is not a thread (coroutine != Thread) ,
            the functionality look similar but they are completely different
    ------------------------------------------------------------------------------------------------------------------------------

     Coroutines are very very Cheap- almost free , you can create thousands of them without any memory issue.and
     this is not possible in Thread we can't create thousands of Threads at a time.

================================================================================================================














What are Coroutines
========================

 */