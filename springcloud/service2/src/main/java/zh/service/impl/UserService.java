package zh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zh.dao.UserMapper;
import zh.entity.User;
import zh.service.IUserService;

@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
}
