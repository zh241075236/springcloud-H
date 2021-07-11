package zh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zh.annotation.TestAnnotation;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("test")
    @TestAnnotation("test")
    public void test(){

    }
}
