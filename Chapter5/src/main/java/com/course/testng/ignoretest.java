package com.course.testng;

import org.testng.annotations.Test;

public class ignoretest {
    @Test
    public void ignoretest1(){
        System.out.println("ignor1执行");
    }
    @Test (enabled = false)
    public void ignoretest2(){
        System.out.println("ignor2不执行");
    }
    @Test(enabled = true)
    public void ignoretest3(){
        System.out.println("ignor3执行");
    }
}

