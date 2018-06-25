package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class gropclass3 {
    public void stu1(){
        System.out.println("gropclass3中运行teacher1");
    }
    public void stu2(){
        System.out.println("gropclass3中运行teacher2");
    }

}
