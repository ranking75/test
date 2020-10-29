package oppo.web.servlet;


import oppo.dao.UserDao;
import oppo.dao.impl.UserDaoImpl;
import oppo.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
    {

        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        System.out.println(username);
        String password = req.getParameter("password");
        System.out.println(password);
        String checkcode=req.getParameter("checkcode");
        System.out.println(checkcode);
        System.out.println("网页获取到的验证码为：");
        HttpSession session = req.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");
        System.out.println("通过session获取到的图片验证码为：");
        System.out.println(checkCode_session);
        if(checkCode_session!=null&&checkCode_session.equalsIgnoreCase(checkcode)){
            System.out.println("验证码正确");
            User loginuser = new User();
            loginuser.setUsername(username);
            loginuser.setPassword(password);
            System.out.println("loginuser:"+loginuser.getUsername());
            System.out.println("loginuser"+loginuser.getPassword());
            System.out.println(loginuser);
            UserDao userdao=new UserDaoImpl();
            Boolean user=userdao.login1(loginuser);
            System.out.println("User刀建立");


            if(user==false)
            {
                System.out.println("查询失败");
                req.setAttribute("show","账号或密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
                return;

            }else {
                System.out.println("账号密码都正确，就是进不去");
                session.setAttribute("user",username);
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
                return;
            }
        }else {
            req.setAttribute("show","验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }


    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
    {
        this.doPost(req,resp);
    }
}
