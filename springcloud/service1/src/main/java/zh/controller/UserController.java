package zh.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import zh.entity.User;
import zh.service.UserService;

@RequestMapping(value = "/user")
@RestController
@CrossOrigin
@Api(description = "用户")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    @ApiOperation(value = "login")
    @ResponseBody
    public String login(String username){
        User user = userService.loadUserByUsername(username);
        return JSON.toJSONString(user);
    }
}
