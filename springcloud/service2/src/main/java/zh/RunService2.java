package zh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"zh.dao"})
public class RunService2 {
    public static void main(String[] args) {
        SpringApplication.run(RunService2.class, args);
    }
}
