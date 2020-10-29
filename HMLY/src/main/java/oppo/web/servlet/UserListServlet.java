package oppo.web.servlet;


import oppo.config.SpringConfig;
import oppo.dao.IUserDao;
import oppo.domain.User;
import oppo.service.UserService;
import oppo.service.impl.UserServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
    {
        System.out.println("hello");
        List<User> users=null;
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userdao =context.getBean("userServiceImpl",UserServiceImpl.class);
        //UserServiceImpl userdao= context.getBean("userServiceImpl", UserServiceImpl.class);
        users=userdao.findAll();
        req.setAttribute("users",users);
        System.out.println("hello");
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
