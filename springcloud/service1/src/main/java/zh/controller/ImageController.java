package zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/image")
public class ImageController {

    @RequestMapping("/upload")
    public void upload(MultipartFile multipartFile){
        try {
            multipartFile.transferTo(new File("E:/image/1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
