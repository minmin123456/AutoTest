package com.course.testng.paramter;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

//date=data,保持一致
public class DateProviderTest {
    @Test(dataProvider = "data")
    public void testDateProvider(String name,int age){
        System.out.println("name="+name+"; age="+age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData() {
        Object[][] o = new Object[][]{{"zhangsan", 10}, {"lisi", 12}, {"wangwu", 15}};
         return o;
    }



//    通过方法名传递参数
   @Test(dataProvider = "methoddate")
    public void test1(String name,int age){
       System.out.println("test111方法 name"+name+";age "+age);

    }
    @Test(dataProvider = "methoddate")
    public void test2(String name ,int age){
        System.out.println("test222方法 name"+name+";age "+age);
    }

@DataProvider(name = "methoddate")
    public Object[][] methdatetest(Method method){
        Object[][] result=null;
        if(method.getName().equals("test1")){

            result=new Object[][]{{"zhangsan",20},{"lisi",25}};

        }else if(method.getName().equals("test2")) {
            result=new Object[][]{{"wangwu",30},{"zhaoliu",45}};

        }
        return  result;
    }


}
