package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@Api(value = "/",description = "这是我全部的post请求")
//@RequestMapping("/v1")---在这里写也可以也可以做直接在下面写22行
public class MyPostMethod {
    /* 这个变量用来获取到Cookie，然后在访问起来接口获取到列表 */

    private static Cookie cookie;

    @RequestMapping(value = "/v1/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies信息", httpMethod = "POST")

    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String userName,
                        @RequestParam(value = "password", required = true) String password
    ) {
        if (userName.equals("wangminmin") && password.equals("123456")) {
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "恭喜你登录成功！";
        }
        return "用户名或者是密码错误！";

    }


    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                              @RequestBody User u) {

        User user;
        //获取cookies
        Cookie[] cookies = request.getCookies();
        //验证cookies是否合法

//        for (Cookie c :cookies){
//            if (c.getName()=="login"&& c.getValue()=="true"
//                    && u.getUsername()=="zhangsan"
//                    &&u.getPassword()=="123456"
//                    ){
//                user=new User();
//                user.setName("lisi");
//                user.setAge("18");
//                user.setSex("man");
//                return user.toString();
//
//            }
//        }

        for (Cookie c :cookies){
            if (c.getName().equals("login")&& c.getValue().equals("true")
                    && u.getUsername().equals("zhangsan")
                    &&u.getPassword().equals("123456")
                    ){
                user=new User();
                user.setName("lisi");
                user.setAge("18");
                user.setSex("man");
                return user.toString();

            }
        }


        return "参数不合法";

    }
}
