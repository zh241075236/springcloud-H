package zh.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 静态资源处理
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/**");
//        registry.addResourceHandler("login.html").addResourceLocations("classpath:/static/");
        // swagger访问配置
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/","classpath:/META-INF/resources/webjars/");
    }
}
