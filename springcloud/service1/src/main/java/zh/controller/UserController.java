package zh.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/count")
    @ResponseBody
    @ApiOperation(value = "count")
    public long count(@RequestParam("user")String json){
        User user = JSON.parseObject(json, User.class);
        long count = userService.count(user);
        return count;
    }
}
