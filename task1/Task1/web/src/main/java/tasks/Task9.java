package tasks;

import java.io.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "task9", value = "/task9")
public class Task9 extends HttpServlet {

    private int hitCount;

    public void init() {
        // Reset hit counter.
        hitCount = 0;
    }

    public void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        destroy();
        // Set response content type
        response.setContentType("text/html");

        // This method executes whenever the servlet is hit
        // increment hitCount
        hitCount++;
        PrintWriter out = response.getWriter();
        String title = "Total Number of Hits";

        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body bgcolor = \"#f0f0f0\">\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<h2 align = \"center\">" + hitCount + "</h2>\n" +
                        "</body> </html>");


    }

    public void destroy() {
        try {
            FileOutputStream fos =new FileOutputStream("count.txt");
            ObjectOutputStream os =new ObjectOutputStream(fos);
            os.writeObject(hitCount);
            os.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // This is optional step but if you like you
        // can write hitCount value in your database.
    }
}
