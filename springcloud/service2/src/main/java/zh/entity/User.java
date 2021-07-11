package zh.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@TableName(value = "User")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
//    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
//    private Integer id;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("role_id")
    private int role_id;
}
