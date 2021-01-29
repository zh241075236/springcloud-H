package zh.jwt;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 认证过滤器
 * 验证用户名密码正确后，生成一个token，并将token返回给客户端
 * 该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法 ,
 * attemptAuthentication：接收并解析用户凭证。
 * successfulAuthentication：用户成功登录后，这个方法会被调用，我们在这个方法里生成token并返回。
 * unsuccessfulAuthentication：登录失败则返回错误信息
 */
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * 用户验证
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>()));

    }

    /**
     * 验证成功后返回
     * @param request
     * @param response
     * @param chain
     * @param auth
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        Claims claims = Jwts.claims();
        claims.put("role", auth.getAuthorities().stream().map(s -> s.getAuthority()).collect(Collectors.toList()));
        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(auth.getName())
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                .signWith(SignatureAlgorithm.HS512, "MyJwtSecret11").compact();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        //跨域响应头
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        Map<String,String> map = new HashMap<>();
        map.put("user", JSON.toJSONString(auth.getPrincipal()));
        map.put("token", token);
        response.addHeader("data", JSON.toJSONString(map));
        PrintWriter out;
        try {
            out = response.getWriter();
            out.print(JSON.toJSONString(map));
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证失败后返回
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response, AuthenticationException failed)
            throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out;
        try {
            out = response.getWriter();
            out.print("用户名或密码错误");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
