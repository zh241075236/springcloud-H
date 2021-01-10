package zh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zh.base.BaseService;
import zh.dao.jpa.UserJpa;
import zh.entity.User;

import java.util.List;

@Service
public class UserService implements BaseService<User> {

    @Autowired
    private UserJpa userJpa;

    @Override
    public List<User> query(User user) {
//        Pageable pageable = new PageRequest(pageNum - 1, 6, sort);
        return null;
    }

    @Override
    public User queryById(String id) {
        return null;
    }

    @Override
    public boolean add(User user) {
        return false;
    }

    @Override
    public boolean batchAdd(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public long count(User user) {
        return userJpa.count();
    }
}
