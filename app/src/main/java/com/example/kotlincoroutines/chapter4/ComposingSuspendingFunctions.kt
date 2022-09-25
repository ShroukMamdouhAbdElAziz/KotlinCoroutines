package com.example.kotlincoroutines.chapter4

/* in this chapter
---------------------
we will see various approaches to compose and execute suspending functions .

we will explore the sequential ,concurrent ,and lazy execution of the code within a coroutine .


sequential execution:
------------------
1.functions execution within a coroutine is sequential by default.

concurrent execution
---------------------
2.Achieve concurrent execution by async{} / execution functions in parallel instead of sequential


lazy coroutine execution
-----------------------
3.how to execute a block of code lazily using coroutine


very important : the methods inside the coroutine blocks are executed by default sequentially
 */

