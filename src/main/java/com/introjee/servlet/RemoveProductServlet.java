package com.introjee.servlet;

import com.introjee.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveProductServlet", value = "/remove")
public class RemoveProductServlet extends HttpServlet {
    private final ProductService productService = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productService.remove(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect(request.getContextPath()+"/product/getAll.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
