package com.course.testng.suite;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class suiteconfig {
    @BeforeSuite
    public void beforsuit(){
        System.out.println("before suite运行啦");
    }
    @AfterSuite
    public void aftersuit(){
        System.out.println("afer suite运行啦");
    }
    @BeforeTest
    public void befortest(){
        System.out.println("befortest");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("AfterTest");
    }
}
