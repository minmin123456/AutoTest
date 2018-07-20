package com.course.httpclicent.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;


import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class myhttpclient {

    @Test
    public void test1() throws IOException {

        //用来存放我们的结果
        String result;
        String url="http://www.baidu.com";

        //首先创建一个HTTP客户端(HttpClient)的对象，也可以称为实例
//        用来执行get方法的，使用HttpClient发送请求、接收响应
        //默认的构造函数
        HttpClient client= new DefaultHttpClient();

         /* 发送GET请求:
        先创建一个HttpGet对象,传入目标的网络地址,然后调用HttpClient的execute()方法即可:
        */
        //HttpGet get=new HttpGet("http://www.baidu.com");
        HttpGet get=new HttpGet(url);

//        所选择的提交方法中读取服务器反馈回来的结果
        //用execute来执行创建好的方法实例请求，获得响应
        HttpResponse response= client.execute(get);
        //response.getEntity();--获取响应的所有内容，
        // EntityUtils.toString（）--用来将内容转化成字符串，这个方法支持多个参数,Utf-8字符编码的问题
        //
        result=EntityUtils.toString(response.getEntity(),"Utf-8");
        System.out.println(result);






    }
}

