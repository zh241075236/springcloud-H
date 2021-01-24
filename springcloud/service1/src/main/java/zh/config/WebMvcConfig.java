package zh.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置静态资源处理
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/**");
        // swagger访问配置
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/","classpath:/META-INF/resources/webjars/");
//        registry.addResourceHandler("swagger").addResourceLocations("classpath:");
    }
}
