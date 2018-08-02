package com.course.server;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value="/",description = "这是我全部的get方法")
public class MyGetMethod {

    @RequestMapping(value="/getCooKies",method=RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到Cookies",httpMethod = "GET")

    public String getCookies(HttpServletResponse response){
        //HttpServerletRequest 装请求信息类
        //HttpServerletResponse 装响应信息的类
        Cookie cookie=new Cookie("name","true");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";

    }

/*
*要求客户端携带cookies访问
*这是一个需要携带Cookie信息才能访问的get请求
*@ApiOperation描述这个方法
 */
   @RequestMapping(value="/get/with/cookies",method = RequestMethod.GET)
   @ApiOperation(value = "要求客户端携带cookies访问",httpMethod = "GET")
    public  String getWithCookies(HttpServletRequest request){
       Cookie[] cookies=request.getCookies();
       if (Objects.isNull(cookies)){
           return "你必须带一个cookies信息来";
       }
       for (Cookie cookie:cookies){
           if(cookie.getName().equals("login")&& cookie.getValue().equals("true"));{
               return "这是一个需要携带Cookie信息才能访问的get请求";
           }
       }
       return "你必须携带Cookie信息来";

   }


   /*
   *开发一个需要携带参数才能访问的get请求
   * 第一种访问方式 URL：key=value&key=value
   * http://localhost:8888/get/with/param?start=100&end=20
   * 我们来模拟获取商品列表

    */
   @RequestMapping(value = "/get/with/param",method=RequestMethod.GET)
   @ApiOperation(value = "需要携带参数才能访问的get请求一",httpMethod = "GET")
    public Map<String,Integer> getlist(@RequestParam Integer start,@RequestParam Integer end ){
       Map<String,Integer> myList=new HashMap<>();
       myList.put("鞋",400);
       myList.put("干脆面",1);
       myList.put("衬衫",300);
       return myList;

    }
    /*
    *第二种需要携带参数访问的get请求
    * URL：IP：port/get/with/param/10/20
    * http://localhost:8888/get/with/param/10/20
    *

     */
    @RequestMapping(value = "/get/with/param/{Start}/{end}",method=RequestMethod.GET)
    @ApiOperation(value = "需要携带参数访问的get请求二",httpMethod = "GET")
    public Map myGetList(@PathVariable Integer Start, @PathVariable Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);
        return myList;
    }



}
