package com.example.kotlincoroutines.chapter5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()  {
    runBlocking { // thread:main


        // coroutine without parameter: Confined  [Confined Dispatcher]
        /* when you create a coroutine without any parameter , then it will inherit the CoroutineContext( inherit the dispatcher
            from the immediate parent. eve after delay() or suspending fun, it continue to run in the same thread.

       so here the child coroutine(launch{}) without any parameter will also execute in the main thread*/

        launch {
            println("C1:${Thread.currentThread().name}") // thread :main
            delay(1000)
            println("C1 after delay:${Thread.currentThread().name}")  // thread :main

        }

        // with parameter :Dispatchers.Default [similar to GlobalScope.launch{}]
        // will create a coroutine at the application level and hence it will execute on a seperate background thread
        launch(Dispatchers.Default) {
            println("C2:${Thread.currentThread().name}")  // thread T1
            delay(1000)
            println("C2 after delay:${Thread.currentThread().name}") // thread T1 or other thread
        }


        //with parameter :Dispatchers.Unconfined  [Unconfined dispatcher]
        // with inherit the coroutineContext(dispatcher ) of parent

        launch(Dispatchers.Unconfined) {
            println("C3:${Thread.currentThread().name}")  // thread :main
            delay(1000)
            println("C3 after delay:${Thread.currentThread().name}")  // thread :some other thread

        }
  // using CoroutineContext property to flow context from parent( here is runBlocking) to child
        launch(coroutineContext){
            println("C4:${Thread.currentThread().name}")  // thread :main
            delay(1000)
            println("C4 after delay:${Thread.currentThread().name}")  // thread :main
        }
    }
}
