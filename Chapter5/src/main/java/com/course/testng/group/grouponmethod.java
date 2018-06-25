package com.course.testng.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class grouponmethod {



    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端的测试方法222");

    }

    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端的测试方法111");

    }

    @Test(groups = "client")
    public void  test3(){
        System.out.println("这是客户端的测试方法333");

    }


    @Test(groups = "client")
    public void  test4(){
        System.out.println("这是客户端的测试方法444");

    }
    @BeforeGroups("server")
    public void BeforeGroupsonserver(){
        System.out.println("这是服务端组运行之前运行的方法");
    }
    @AfterGroups ("server")
    public void AfterGroupsonserver(){
        System.out.println("这是服务端组运行之后运行的方法");
    }
    @BeforeGroups("client")
    public void BeforeGroupsonclient(){
        System.out.println("这是客户端组运行之前运行的方法");
    }
    @AfterGroups ("client")
    public void AfterGroupsonclient(){
        System.out.println("这是客户端组运行之后运行的方法");
    }



}
