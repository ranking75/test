package oppo.dao;


import oppo.domain.User;

import java.util.List;

public interface IUserDao {
    public void save(User user);
    public List<User> findAll();
    void addUser(User user);
    User login(User loginuser);
    public User findByUsername(String username);

    public User findBycode(String code);
}
