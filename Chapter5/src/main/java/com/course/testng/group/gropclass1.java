package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class gropclass1 {
    public void stu1(){
        System.out.println("gropclass1中运行111");
    }
    public void stu2(){
        System.out.println("gropclass1中运行222");
    }


}
