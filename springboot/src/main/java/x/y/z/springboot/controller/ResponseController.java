package x.y.z.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import x.y.z.springboot.model.Response;
import x.y.z.springboot.model.vo.UserVo;

@RestController
public class ResponseController {

    @RequestMapping(value = "/getUser")
    public Response<UserVo> simpleParam1() {
        Response<UserVo> response = new Response<>();
        response.setCode("0");
        response.setMessage("ok");
        UserVo userVo = new UserVo();
        userVo.setName("tom");
        userVo.setAge(10);
        response.setData(userVo);
        return response;
    }
}
