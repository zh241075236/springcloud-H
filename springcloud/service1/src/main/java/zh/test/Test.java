package zh.test;

import zh.annotation.TestAnnoation;


public class Test {

    @TestAnnoation
    public static void main(String[] args) {
        System.out.println("解析注解");
    }

}
