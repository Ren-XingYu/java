package x.y.z.springboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import x.y.z.springboot.model.dto.UserDto;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class RequestController {

    @RequestMapping(value = "/simpleParam1")
    public String simpleParam1(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(name + ":" + age);
        return "OK";
    }

    @RequestMapping(value = "/simpleParam2")
    public String simpleParam2(@RequestParam("name") String username, Integer age) {
        System.out.println(username + ":" + age);
        return "OK";
    }

    @RequestMapping(value = "/simpleParam3")
     public String simpleParam3(UserDto user) {
        System.out.println(user);
        return "OK";
    }

    // 数组参数封装: hobby=java&hobby=linux, 默认方式
    @RequestMapping(value = "/arrayParam")
    public String arrayParam(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    // 集合参数封装: hobby=java&hobby=linux, 需要加RequestParam
    @RequestMapping(value = "/listParam")
    public String listParam(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "OK";
    }

    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);
        return "OK";
    }

    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody UserDto user){
        System.out.println(user);
        return "OK";
    }

    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id){
        System.out.println(id);
        return "OK";
    }
}
