package com.example.kotlincoroutines

import kotlin.concurrent.thread

fun main(){  // main Function Executes in the Main Thread

    println("Main Program starts :${Thread.currentThread().name}")


   thread { // creating worker thread or background thread with lambda expression
       println("Fake work starts: ${Thread.currentThread().name}")
       Thread.sleep(1000)  // pretending doing some work ...maybe file upload


       println("Fake work ends: ${Thread.currentThread().name}")
   }

    println("Main Program ends :${Thread.currentThread().name}")

}

/*
  the output will be as below
  --------------------------
    Main Program starts :main
    Main Program ends :main
    Fake work starts: Thread-0
    Fake work ends: Thread-0

    which means the code in the background thread doesnot block the code in the main thread
      ( they work in parallel, concurrent manner) as we see the

    " Main Program ends :main" printed before the background thread

    Note that :
    ============
    even after the last statement in the main fun executed ,the app waiting for the background thread to
    execute and complete and only after the tasks in the background thread executed , the app will be ended


    run the main Fun again and noted this ' Process finished with exit code 0 '

    So on case of thread , the app waiting for all the application threads to be completed in order to the app be ended(.
 */