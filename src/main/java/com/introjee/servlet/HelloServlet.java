package com.introjee.servlet;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/pageOne")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        System.out.println("servlet créé");
        message = "Hello yassin!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
        System.out.println("servlet detruit");
    }
}