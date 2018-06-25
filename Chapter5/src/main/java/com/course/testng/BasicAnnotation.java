package com.course.testng;


import org.testng.annotations.*;

public class BasicAnnotation {

    @Test
    public  void testcase1(){
        System.out.println("这是测试用例1");

    }
    @Test
    public  void testcase2(){
        System.out.println("这是测试用例2");

    }
    @BeforeMethod
    public void  beforeMethod(){
        System.out.println("在方法之前运行");
    }
    @AfterMethod
    public  void afterMethod(){
        System.out.println("在方法之后运行");
    }
    @BeforeClass
    public  void beforclass(){
        System.out.println("这是在类运行之前运行");
    }
    @AfterClass
    public void afterclass(){
        System.out.println("这是在类运行之后运行");

    }

    @BeforeSuite
    public  void beforSuite(){
        System.out.println("beforSuite测试套件");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite测试套件");
    }



}
