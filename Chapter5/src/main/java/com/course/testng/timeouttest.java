package com.course.testng;

import org.testng.annotations.Test;



public class timeouttest {
    @Test(timeOut = 3000)//单位毫秒
    public void testsuccess() throws InterruptedException {
        Thread.sleep(2000);

    }
    @Test(timeOut = 2000)
    public void testFailed() throws InterruptedException {
        Thread.sleep(2000);

    }
}
