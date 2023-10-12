package zadanie;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;

@WebServlet(name = "task12", value = "/task12")
public class Task12 extends HttpServlet {

    private int hitCount;

    public void init() {
        // Reset hit counter.
        hitCount = 0;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        destroy();

        response.setContentType("image/jpeg");

        BufferedImage image =new BufferedImage(500,200 ,
                BufferedImage.TYPE_INT_BGR);

        String str = String.valueOf(hitCount++);

        Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("Serif",Font.ITALIC,48));
        graphics.setColor(Color.green);
        graphics.drawString(str,100,100);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpeg",out);


    }


}