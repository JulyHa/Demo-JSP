package com.example.demojstl.controller;

import com.example.demojstl.model.Product;
import com.example.demojstl.service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                response.sendRedirect("view/create.jsp");
                break;
            case "edit":
                showEdit(request, response);
                break;
            case "delete":
                deleteProduct(request , response);
                break;
            default:
                showList(request, response);
                break;
        }


    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        response.sendRedirect("/ProductServlet");
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Product product = productService.findByID(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
        dispatcher.forward(request, response);

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/display.jsp");
        request.setAttribute("listProduct", productService.finAll());
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");


        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                int id = Integer.parseInt(request.getParameter("id"));
                int amount = Integer.parseInt(request.getParameter("amount"));
                String name = request.getParameter("name");
                String des = request.getParameter("des");

                Product product = new Product(id, name, amount, des);
                productService.add(product);
//        request.setAttribute("listProduct",productService.finAll());
//        RequestDispatcher dispatcher=request.getRequestDispatcher("view/display.jsp");
//        dispatcher.forward(request,response);
                response.sendRedirect("/ProductServlet");
                break;
            case "edit":
                editProduct(request, response);
                break;
            default:

                break;
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int amount = Integer.parseInt(request.getParameter("amount"));
        String des = request.getParameter("des");
        Product product = new Product(id , name , amount , des);
        this.productService.edit(id , product);
        response.sendRedirect("/ProductServlet");
    }


}
