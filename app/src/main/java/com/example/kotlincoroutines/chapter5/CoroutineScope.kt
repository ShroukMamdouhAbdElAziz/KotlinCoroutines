package com.example.kotlincoroutines.chapter5

import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
/* coroutine Scope : represents what kind of coroutine has been created*/


fun main() {

    runBlocking {
        println("run Blocking: $this") //output:run Blocking: BlockingCoroutine{Active}

        // each coroutine has its own coroutineScope
        launch {
            println("launch: $this") // output:launch: StandaloneCoroutine{Active}@72b6cbcc

            launch {
                println(" child launch: $this")// output: child launch: StandaloneCoroutine{Active}@7494e528
            }
        }

        async {
            println("async: $this") // output:async: DeferredCoroutine{Active}
        }
    }
}