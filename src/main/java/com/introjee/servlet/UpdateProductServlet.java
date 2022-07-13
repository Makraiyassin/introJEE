package com.introjee.servlet;

import com.introjee.models.Product;
import com.introjee.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateProductServlet", value = "/update")
public class UpdateProductServlet extends HttpServlet {
    private final ProductService productService = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        try{
            id = Integer.parseInt(request.getParameter("id"));
        }catch (Exception e){
            System.out.println(e);
        }
        Product p = productService.getOne(id);
        request.setAttribute("product", p);
        request.getRequestDispatcher("/product/updateProduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("dopost de update servlet");
        String name = request.getParameter("name");
        String brand= request.getParameter("brand");
        String category= request.getParameter("category");
        int id = 1;
        try{
            id =  Integer.parseInt(request.getParameter("id"));
            double price= Double.parseDouble(request.getParameter("price"));
            Product toUpdate = new Product(id, name,brand,category,price);
            productService.update(toUpdate);
            response.sendRedirect(request.getContextPath()+"/product/getAll.jsp");
        }catch (NumberFormatException e){
            System.out.println(e);
            response.sendRedirect(request.getContextPath()+"/product/getAll.jsp");
        }
    }
}
