package com.course.testng.multThread;

import org.testng.annotations.Test;
//多线程
public class mulithreadonaction {
//    线程池中有3个线程
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        //多线程打印线程ID
        System.out.printf("thread id :%s%n",Thread.currentThread().getId());
    }
}
