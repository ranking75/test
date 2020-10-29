package oppo.web.servlet;

import oppo.dao.IUserDao;
import oppo.domain.ResultInfo;
import oppo.domain.User;
import oppo.service.UserService;
import oppo.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registerUserServlet")
public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String,String[]> map = req.getParameterMap();
        User user=new User();
        try {
            BeanUtils.populate(user,map);
            System.out.println(user.getUsername()+user.getPassword()+user.getEmail());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService service=new UserServiceImpl();
        boolean flag=service.regist(user);
        ResultInfo info=new ResultInfo();
        if(flag){
            info.setFlag(true);
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("注册成功");
        }else {
            info.setFlag(false);
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("请点击邮箱进行激活");
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
    {
        this.doGet(req,resp);
    }
}

