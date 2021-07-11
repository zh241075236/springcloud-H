package zh.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zh.common.Response;
import zh.entity.User;
import zh.service.IUserService;

import java.util.List;


@RestController
@RequestMapping("user")
@Api("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("query")
    @ApiOperation("query")
    public Response query(@RequestParam("user") User user){
        List<User> list = userService.list();
        return Response.response(null,list);
    }

}
