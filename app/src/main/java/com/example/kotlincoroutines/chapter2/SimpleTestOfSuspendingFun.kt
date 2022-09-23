package com.example.kotlincoroutines.chapter2

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test


class SimpleTestOfSuspendingFun{

    @Test
    fun myFirstTest()= runBlocking{
        myOwnSuspendingFunc()  // compiler error we can call only suspend fun from coroutine or other suspend fun
        Assert.assertEquals(10,5+5)
    }
}

/* runBlocking , always block the thread in which it operates.*/