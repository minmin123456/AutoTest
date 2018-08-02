package com.course.httpclicent.cookies;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@SuppressWarnings("Duplicates")
public class Mycookiesforget {

    private String url;
    //java的ResourceBundle类是用来读取properties的资源文件的，很多国际化操作都使用该类。
    //ResourceBundle读取配置文件信息用的
    private ResourceBundle bundle;
    private CookieStore store;
    @BeforeTest
    public void  beforeTest(){
//        方法获取使用指定的基本名称，默认的语言环境和调用者的类加载器获取资源包。
//        资源包resources,下面的文件文件名，不用输入后缀名,Locale.CHINA是为了解决字符编码问题
        bundle=ResourceBundle.getBundle("application",Locale.CHINA);

        url=bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        //重配置文件中拼接测试的url
        String uri = bundle.getString("getCookies.uri");
        String testurl = this.url + uri;
        String result;
        //代码逻辑的书写
        //获取响应信息
        HttpGet get = new HttpGet(testurl);
        // HttpClient client=new DefaultHttpClient();
        //HttpClient这两个类下面的DefaultHttpClient（），不能执行获取cookie信息
        //如果想获取cookie信息HttpClient改成DefaultHttpClient类即可
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "Utf-8");
        System.out.println(result);
//        获取cookie信息
        this.store = client.getCookieStore();
         List<Cookie> cookielist=store.getCookies();
         for (Cookie cookie:cookielist){
             String name=cookie.getName();
             String value=cookie.getValue();
             System.out.println("cookie name ="+name+";cookie value ="+value);
         }
    }
    //要执行以下方法，需要先执行testGetCookies()，
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testgetwithcookies() throws IOException {

        String uri = bundle.getString("test.get.with.cookies");
        String testurl=this.url+uri;
        HttpGet get =new HttpGet(testurl);
        DefaultHttpClient client=new DefaultHttpClient();
        //设置cookie信息
        client.setCookieStore(this.store);

        HttpResponse response =client.execute(get);
        //获取响应状态码
        int statuscode=response.getStatusLine().getStatusCode();
        System.out.println("statuscode="+statuscode);
        if(statuscode==200){
            String result =EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }
        

    }
}
