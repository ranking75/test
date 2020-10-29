package oppo.dao.impl;


import jdk.jfr.Registered;
import oppo.dao.UserDao;
import oppo.domain.User;
import oppo.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
@Repository(value ="userDaoImpl")
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        String sql="select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User login(User loginuser) {
        User user=null;
        try {
            String sql="select * from user where username=? and password=?";
            System.out.println(loginuser.getUsername()+"   "+loginuser.getPassword());
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginuser.getUsername(), loginuser.getPassword());

        }catch (Exception e)
        {
        }
        return user;
    }
    @Override
    public void addUser(User user) {
        String sql="insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql, user.getName(), user.getGender(), user.getAge(),user.getAddress(), user.getQq(), user.getEmail());
        return ;
    }

    @Override
    public boolean  login1(User loginuser) {
        String username=loginuser.getUsername();
        String password=loginuser.getPassword();
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            con=JDBCUtils.getConnection();
            stmt=con.createStatement();
            String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";

            rs=stmt.executeQuery(sql);
            if(rs.next())
            {
                return  true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public boolean findByUsername(String username) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        int cout=0;
        try {
            con=JDBCUtils.getConnection();
            stmt=con.createStatement();
            String sql = "select * from user where username = '"+username+"'";

            rs=stmt.executeQuery(sql);
            while (rs.next())
            {
                cout++;
            }
            if(cout>0)
            {
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

//    @Override
//    public void save(User user) {
//        String sql="insert into user values(null,null,null,null,null,null,?,?,?)";
//        template.update(sql,user.getEmail(),user.getUsername(),user.getPassword());
//        return;
//
//
//    }
}