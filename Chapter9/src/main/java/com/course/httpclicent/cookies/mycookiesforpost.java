package com.course.httpclicent.cookies;


import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
//import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class mycookiesforpost {
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
    @Test(dependsOnMethods = {"testGetCookies"})

    public void testpostCookies() throws IOException {
        String uri=bundle.getString("test.post.with.cookies");
        String testurl=this.url+uri;
//        声明一个client对象，用来进行方法的执行
        DefaultHttpClient client=new DefaultHttpClient();

//        声明一个方法，这个方法就是post方法
        HttpPost post=new HttpPost(testurl);

//        添加参数
        JSONObject param =new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");

//        设置请求头信息设置header
        post.setHeader("content-type","application/json");

//        将参数信息添加到方法中
        StringEntity entity =new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

//        声明一个对象来进行响应结果的存储
        String result;

//        设置cookies信息
        client.setCookieStore(this.store);

//        执行post方法
        HttpResponse response=client.execute(post);

//        获取响应结果
        result =EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

//        处理结果就是判断返回结果的是否符合预期
//        将返回的响应结果字符串转化成json 对象
        JSONObject resultJson=new JSONObject(result);
//        获取到结果值
        String success= (String) resultJson.get("huahansan");
        String Status=(String) resultJson.get("status");
//        具体的判断返回结果的值
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",Status);






    }
}
