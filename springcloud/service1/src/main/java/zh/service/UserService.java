package zh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zh.dao.jpa.UserJpa;
import zh.dao.mapper.UserMapper;
import zh.entity.User;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserJpa userJpa;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);
        return user;
    }
}
