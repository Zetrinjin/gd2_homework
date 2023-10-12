package task10;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NameServlet", urlPatterns = "/nameservlet")
public class Task10 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Read data from Request
        String name = req.getParameter("name");
        System.out.println("Name: " + name);
        String phone =req.getParameter("phone");
        System.out.println("Phone: " + phone);
        String email =req.getParameter("email");
        System.out.println("Email: " + email);

        // Send Response to browser
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        if (name=="" && (phone=="" || email=="")){
            out.println("<h2>" + "ERROR" + "</h2>");
        }
        else {
            out.println("<h2>" + name + "</h2>");
            out.println("<h2>" + phone + "</h2>");
            out.println("<h2>" + email + "</h2>");

        }

        out.println("<a href='/web/form.html'>Back</a>");
        out.println("</html>");
    }
}
