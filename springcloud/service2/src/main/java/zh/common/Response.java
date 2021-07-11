package zh.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import zh.entity.User;


/**
 * 统一返回对象
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private CodeEnum code;
    private String message;
    private Object data;

    public static Response response(String msg,Object t){
        if(msg == null){
            return new Response(CodeEnum.SUCCESS,"成功",t);
        }else{
            return new Response(CodeEnum.FAIL, msg, t);
        }
    }
}
