package com.course.testng;

import org.testng.annotations.Test;

//依赖测试应用场景，比如你要下单，那么要先登录，登录都没有成功的话，就不用下单了
@Test
public class DependTest {
    public void test1(){
        System.out.println("test1 run");
        throw new RuntimeException();
    }
    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run");
    }
}
