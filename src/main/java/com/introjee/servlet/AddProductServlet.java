package com.introjee.servlet;

import com.introjee.models.Product;
import com.introjee.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.stream.Stream;

@WebServlet(name = "AddProductServlet", value = "/add")
public class AddProductServlet extends HttpServlet {
    private final ProductService productService = ProductService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String brand= request.getParameter("brand");
        String category= request.getParameter("category");
        try{
            double price= Integer.parseInt(request.getParameter("price"));
            Product toInsert = new Product(name,brand,category,price);
            int id = productService.insert(toInsert);
            response.sendRedirect(request.getContextPath()+"/product/getOne.jsp?id="+id);
    //        request.getRequestDispatcher(request.getContextPath()+"/product/getOne.jsp?id="+id).forward(request,response);
        }catch (NumberFormatException e){
            request.getRequestDispatcher("/product/addProduct.jsp").forward(request,response);
//            response.sendRedirect(request.getContextPath()+"/product/addProduct.jsp");
        }
    }
}
