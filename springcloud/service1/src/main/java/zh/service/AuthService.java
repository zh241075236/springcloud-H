package zh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import zh.entity.User;

/**
 * 鉴权
 */
@Service
public class AuthService implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    /**
     * 用户名密码验证并鉴权
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //提交上来的用户名密码
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        //读取数据库用户数据
        User user = userService.loadUserByUsername(username);
//        String encode = new BCryptPasswordEncoder().encode(password);//处理加密后的密码
        //密码认证成功后，生成token
        if(user != null && user.getPassword().equals(password)) {
            return new UsernamePasswordAuthenticationToken(username, user.getPassword(), user.getAuthorities());
        } else {
            throw new BadCredentialsException("用户名或密码错误");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
