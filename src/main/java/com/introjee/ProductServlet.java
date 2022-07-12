package com.introjee;

import com.introjee.models.Product;
import com.introjee.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet(name = "ProductServlet", value = "/productServlet")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = ProductService.getInstance();
    private final List<Product> productList = productService.getAll();
    public void init() throws ServletException{
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id == null) {
            getAll(response);
        }else{
            getOne(response, Integer.parseInt(id));
        }
    }

    private  void getOne(HttpServletResponse response, int id) throws ServletException, IOException{
        response.setContentType(("text/html"));
        response.setStatus(200);
        PrintWriter out = response.getWriter();
        Product product = productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
//                .collect(Collectors.toList())
//                .get(0);
        if(product == null) response.setStatus(404);
        out.println(
                """
                    <!DOCTYPE html>
                    <html lang="en">
                    <head>
                        <meta charset="UTF-8">
                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>Document</title>
                    </head>
                    <body>
                        <h1>Detail d'un produit</h1>
                        <ul>
                """
        );
        out.printf(
                """
                     <li>
                         <div>
                             <p><span>id: </span> %s</p>
                             <p><span>nom: </span> %s </p>
                             <p><span>marque: </span> %s </p>
                             <p><span>categorie: </span> %s </p>
                             <p><span>prix: </span> %s </p>
                         </div>
                     </li>
                """, product.getId(), product.getName(), product.getMarque(), product.getCategory(), product.getPrice()
        );
        out.println(
                """
                        </ul>
                    </body>
                    </html>
                """
        );
    }
    private  void getAll(HttpServletResponse response) throws ServletException, IOException{
        response.setContentType(("text/html"));
        response.setStatus(200);
        PrintWriter out = response.getWriter();

        for (Product product : productList) {
            out.println(
                    """
                        <!DOCTYPE html>
                        <html lang="en">
                        <head>
                            <meta charset="UTF-8">
                            <meta http-equiv="X-UA-Compatible" content="IE=edge">
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <title>Document</title>
                        </head>
                        <body>
                            <h1>liste produit</h1>
                            <ul>
                    """
            );
            out.printf(
                    """
                             <li>
                                 <div>
                                     <p><span>id: </span> %s</p>
                                     <p><span>nom: </span> %s </p>
                                     <p><span>marque: </span> %s </p>
                                     <p><span>categorie: </span> %s </p>
                                     <p><span>prix: </span> %s </p>
                                 </div>
                             </li>
                            """, product.getId(), product.getName(), product.getMarque(), product.getCategory(), product.getPrice()
            );
            out.println(
                    """
                            </ul>
                        </body>
                        </html>
                    """
            );
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
