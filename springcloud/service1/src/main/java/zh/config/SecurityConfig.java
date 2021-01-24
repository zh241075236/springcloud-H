package zh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import zh.service.UserService;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    /**
     * 请求拦截
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/swagger*/**","/webjars/**","/v2/**","/csrf/**","/user/login/**").permitAll()//swagger放行
                .anyRequest().authenticated()
                //登录放行
//                .and().formLogin().loginPage("login.html").loginProcessingUrl("/user/login").permitAll()
                //登录失败页面
//                .failureUrl("/login.html?error")
                //失败后处理
//                .failureHandler((request, response, excepotion) -> {
//                    request.getRequestDispatcher(request.getRequestURL().toString()).forward(request, response);
//                })
                //登录成功后跳转页面
//                .defaultSuccessUrl("/").permitAll()
                .and().csrf().csrfTokenRepository(new HttpSessionCsrfTokenRepository());
    }

    /**
     * 登录验证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        JdbcUserDetailsManager manager = auth.jdbcAuthentication().dataSource(dataSource).getUserDetailsService();
        auth.userDetailsService(new UserService());
        //创建用户并加密
//        manager.createUser(User.withUsername("root")
//                .password(new BCryptPasswordEncoder().encode("123"))
//                .roles("admin")
//                .build());
    }


//    @Bean
//    protected UserDetailsService userDetailsService() {
//        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
//
//        return manager;
//    }


    /**
     * 密码加密
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
