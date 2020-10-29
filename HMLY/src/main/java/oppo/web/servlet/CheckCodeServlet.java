package oppo.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
    {
        int  wigth=100;
        int heiget=50;
        BufferedImage image = new BufferedImage(wigth,heiget,BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.setColor(Color.pink);
        g.fillRect(0,0,wigth,heiget);
        g.setColor(Color.blue);
        g.drawRect(0,0,wigth-1,heiget-1);

        String str="ABCDEFGHIJKLMNOPQRSTUVWSYZabcdefghijklmnopqrstuvwsyz0123456789";
        Random random = new Random();
        StringBuilder strAarray = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index  = random.nextInt(str.length());
            char ch= str.charAt(index);
            strAarray.append(ch);
            g.drawString(ch+"",wigth/5*i,heiget/2);
        }
        String checkCode_session = strAarray.toString();
        req.getSession().setAttribute("checkCode_session",checkCode_session);

        for (int i = 0; i <3; i++) {
            int x1 = random.nextInt(wigth);
            int x2 = random.nextInt(wigth);
            int y1 = random.nextInt(heiget);
            int y2 = random.nextInt(heiget);
            g.setColor(Color.green);
            g.drawLine(x1,y1,x2,y2);
         }



        ImageIO.write(image,"jpg",resp.getOutputStream());


    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        this.doPost(req,resp);
    }

}
