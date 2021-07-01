package zh.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt工具类
 */
@Data
public class JWTUtil {
    //签名私钥
    private final static String key = "dhifuho23467ghasisabncv893274923";
    //签名有效时间
    private static Long timeOut = 3000L;


    /**
     * 设置认证token
     *      id:用户id
     *      subject:用户名
     */
    public static String createJwt(String name, Map<String,Object> map) {
        //1.设置失效时间
        long nowTime = System.currentTimeMillis();//当前毫秒
        long expirationTime = nowTime + timeOut;
        //2.创建jwtBuilder
        JwtBuilder jwtBuilder = Jwts.builder();
        //3.根据map设置claims
        //当设置的是整个map时，就需放在最前面，下面的setId等参数才会有效，否则会把前面set的值置空
        jwtBuilder.setClaims(map);
        jwtBuilder.setSubject(name);
        jwtBuilder.setIssuedAt(new Date());//设置当前时间
        jwtBuilder.signWith(SignatureAlgorithm.HS256, key);//设置加密方式
        jwtBuilder.setExpiration(new Date(expirationTime));//设置过期时间
        //4.创建token
        String token = jwtBuilder.compact();
        return token;
    }

    /**
     * 解析token字符串获取clamis
     */
    public static Claims parseJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }

}
