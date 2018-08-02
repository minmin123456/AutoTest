package hello;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.*;

//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.*;

//import org.springframework.stereotype.Controller;
import org.springframework.stereotype.*;

//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {
    @RequestMapping("/")
    @ResponseBody
    String home (){
        return "hello world";
    }
    public static void main(String[] args) throws Exception{
        SpringApplication.run(SampleController.class, args);
    }


}
