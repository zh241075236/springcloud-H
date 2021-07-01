//package zh.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
//import zh.jwt.JWTAuthenticationFilter;
//import zh.jwt.JWTLoginFilter;
//import zh.service.AuthService;
//import zh.service.UserService;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private AuthService authService;
//
//    /**
//     * 请求拦截
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().authorizeRequests()
//                .antMatchers("/admin/**").hasRole("admin")//admin权限可访问的请求路径
////                .antMatchers("/static/**","/swagger*/**","/webjars/**","/v2/**","/csrf/**","/login/**").permitAll()//请求放行
//                .anyRequest().authenticated()
//                //登录放行
//                .and().formLogin().loginProcessingUrl("/login").permitAll()//框架默认为/login
//                //登录失败页面
////                .failureUrl("/login.html?error")
//                //失败后处理
////                .failureHandler((request, response, excepotion) -> {
////                    request.getRequestDispatcher(request.getRequestURL().toString()).forward(request, response);
////                })
//                //登录成功后跳转页面
//                .and().csrf().csrfTokenRepository(new HttpSessionCsrfTokenRepository()).and()
//                .addFilter(new JWTLoginFilter(authenticationManager()))//登陆认证，仅登陆拦截
//                .addFilter(new JWTAuthenticationFilter(authenticationManager()))//鉴权，除登陆外都拦截
//                ;
//    }
//
//
//    /**
//     * 放行策略
//     * @param web
//     * @throws Exception
//     */
////    @Override
////    public void configure(WebSecurity web) throws Exception {
////        web.ignoring().antMatchers("/static/**");
////    }
//
//    /**
//     * 登录 鉴权
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(passwordEncoder()).and().authenticationProvider(authService);
//    }
//
//
//    /**
//     * 密码加密
//     * @return
//     */
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}
