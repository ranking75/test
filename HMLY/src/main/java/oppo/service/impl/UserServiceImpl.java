package oppo.service.impl;


import oppo.dao.IUserDao;
import oppo.dao.UserDao;
import oppo.dao.impl.UserDaoImpl;
import oppo.domain.User;
import oppo.service.UserService;
import oppo.util.MailUtils;
import oppo.util.UuidUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@Component(value ="userServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier(value = "userDaoImpl")
    private UserDao dao;
    private InputStream in;
    private SqlSession session;
    private IUserDao userdao;


    @Override
    public List<User> findAll() {
        List<User> users = dao.findAll();
        return users;
    }
    public void init()  {

        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            SqlSessionFactory factory=builder.build(in);
            session=factory.openSession();
            userdao=session.getMapper(IUserDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void close()  {
        try {
            session.commit();
            session.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(User user) {
        init();
        userdao.addUser(user);
        close();
        return ;
    }

    @Override
    public User login(User loginuser) {
        User user=new User();
        init();
        user= userdao.login(loginuser);
        close();
        return user;
    }

    @Override
    public User findByUsername(String username) {
        init();
        User flag = userdao.findByUsername(username);
        close();
        return flag;
    }

    @Override
    public boolean regist(User user) {
        System.out.println(user.getUsername());
        User ff=findByUsername(user.getUsername());
        System.out.println("findByUsername成功");
        if (ff!=null)
        {
            return false;
        }else {
            user.setCode(UuidUtil.getUuid());
            user.setStatus("N");
            addUser(user);
            String content="<a href='http://localhost/day04/acativeUserServlet?code="+user.getCode()+"'>点击激活【黑马旅游网】</a>";
            System.out.println(content);
            MailUtils.sendMail(user.getEmail(),content,"测试邮件");
            return true;
            }

        }

    @Override
    public boolean active(String code) {
        init();
        User user=userdao.findBycode(code);
        close();
        if(user!=null)
        {
            //这个Y没入库
            user.setStatus("Y");
            return true;
        }else {
            return false;
        }
    }
}
