package oppo.dao;


import oppo.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

    User login(User loginuser);
    public boolean login1(User loginuser);
    void addUser(User user);
    public boolean findByUsername(String username);

}
