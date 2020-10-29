package oppo.service;


import oppo.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component(value ="userService")
public interface UserService {
    //查询所有用户信息
    public List<User> findAll();
    public void addUser(User user);
    public User login(User loginuser);
    public User findByUsername(String username);
    boolean regist(User user);

    boolean active(String code);
}
