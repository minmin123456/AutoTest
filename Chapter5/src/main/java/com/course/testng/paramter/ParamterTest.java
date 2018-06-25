package com.course.testng.paramter;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterTest {

    @Test
//    在paramter.xml中被传参数
    @Parameters({"name","age"})

    public void paramterTest1(String name, int age){
        System.out.println("name="+name+"； age="+age);
    }
}
