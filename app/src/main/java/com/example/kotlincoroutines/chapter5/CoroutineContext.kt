package com.example.kotlincoroutines.chapter5

/* CoroutineContext : similar to CoroutineScope , every coroutine has its CoroutineContext but with a twist.

   As mentioned , the CoroutineScope is unique for each Coroutine ( even the parent and child), but coroutineContext can be inherited from
   Parent to child , meaning that the child coroutine can inherit the properties from the parent coroutine.


   CoroutineContext has basically two major components
   --------------------------------------------------
     1.Dispatcher which decides on which thread the coroutine will be execute.
     2.job object , with it we can control the coroutine


     And apart from these two, we can also assign a name to the coroutine


     Note
     ------------

    if you want to access the coroutine scope you can use:
          this : coroutineScope instance*

    if you want to access the coroutineContext of the coroutineScope ( runBlocking here) , you can use a property of :
      coroutineContext :CoroutineContext instance


    the coroutineContext play role in determining the thread of each coroutine.

 */