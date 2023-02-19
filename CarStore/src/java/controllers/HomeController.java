/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cart.Cart;
import db.Product;
import db.ProductFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PHT
 */
@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String controller = (String) request.getAttribute("controller");
        String action = (String) request.getAttribute("action");
        switch (action) {
            case "index":
                try {
                    HttpSession session = request.getSession();
                    String searchField = (String) session.getAttribute("searchField");
                    String searchText = (String) session.getAttribute("searchText");
                    String operator = (String) session.getAttribute("operator");

                    int pageSize = 6;
                    String sPage = request.getParameter("page");
                    int page = 1;
                    if (sPage != null) {
                        page = Integer.parseInt(sPage);
                    }

                    String op = request.getParameter("op");
                    if (op != null) {
                        if (op.equals("search")) {
                            searchField = request.getParameter("searchField");
                            searchText = request.getParameter("searchText");
                            operator = request.getParameter("operator");
                            session.setAttribute("searchField", searchField);
                            session.setAttribute("searchText", searchText);
                            session.setAttribute("operator", operator);
                        } else if (op.equals("searchClear")) {
                            searchField = null;
                            searchText = null;
                            operator = null;
                            session.removeAttribute("searchField");
                            session.removeAttribute("searchText");
                            session.removeAttribute("operator");
                        } else if (op.equals("addToCart")){
                            //Lấy cart trong session ra
                            Cart cart = (Cart)session.getAttribute("cart");
                            //Nếu trong session chưa có cart thì tạo mới cart
                            if(cart == null){
                                cart = new Cart();
                                session.setAttribute("cart", cart);
                            }
                            int id = Integer.parseInt(request.getParameter("id"));
                            //Thêm item tương ứng với id vào cart
                            cart.add(id, 1);                            
                        }
                    }

                    ProductFacade pf = new ProductFacade();
                    int count = 0;
                    List<Product> products = null;
                    if (searchField != null && searchText != null) {
                        count = pf.count(searchField, searchText, operator);
                        System.out.println("Count"+count);
                        products = pf.select(page, pageSize, searchField, searchText, operator);
                    } else {
                        count = pf.count();
                        products = pf.select(page, pageSize);
                    }
                    int numOfPages = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

                    request.setAttribute("products", products);
                    request.setAttribute("page", page);
                    request.setAttribute("numOfPages", numOfPages);
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                } catch (Exception ex) {
                    //In thong tin chi tiet ve exception trong cua so Output de nguoi lap trinh xem
                    ex.printStackTrace();
                    //Chuyen den trang thong bao loi
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
