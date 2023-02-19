/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cart.Cart;
import db.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Alert;

/**
 *
 * @author PHT
 */
@WebServlet(name = "CartController", urlPatterns = {"/cart"})
public class CartController extends HttpServlet {

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

        //Lấy cart trong session ra
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        //Nếu trong session chưa có cart thì tạo mới cart
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        switch (action) {
            case "index":
                try {
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
            case "delete":
                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    cart.remove(id);
                    response.sendRedirect(request.getContextPath() + "/cart/index.do");
                } catch (Exception ex) {
                    //In thong tin chi tiet ve exception trong cua so Output de nguoi lap trinh xem
                    ex.printStackTrace();
                    //Chuyen den trang thong bao loi
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            case "update":
                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    cart.update(id, quantity);
                    response.sendRedirect(request.getContextPath() + "/cart/index.do");
                } catch (Exception ex) {
                    //In thong tin chi tiet ve exception trong cua so Output de nguoi lap trinh xem
                    ex.printStackTrace();
                    //Chuyen den trang thong bao loi
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            case "empty":
                try {
                    cart.empty();
                    response.sendRedirect(request.getContextPath() + "/cart/index.do");
                } catch (Exception ex) {
                    //In thong tin chi tiet ve exception trong cua so Output de nguoi lap trinh xem
                    ex.printStackTrace();
                    //Chuyen den trang thong bao loi
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            case "checkout":
                try {
                    Account account = (Account) session.getAttribute("account");
                    //Neu customer chua login thi bat buoc phai login truoc khi checkout
                    if (account == null) {
                        //Lưu url hiện tại để quay trở lại sau khi login
                        session.setAttribute("oldUrl", "/cart/checkout.do");
                        //Chuyen ve trang /cart/index.do va hien hop thoai login
                        response.sendRedirect(request.getContextPath() + "/cart/index.do?login=1");
                    } else {
                        cart.checkout(account.getId());
                        //Xoa cart
                        cart.empty();
                        //Quay ve trang chu & thong bao checkout thanh cong
                        Alert alert = new Alert("success", "Checkout successfully", "Thank you for your order.");
                        session.setAttribute("alert", alert);
                        response.sendRedirect(request.getContextPath() + "/home/index.do?alert=1");
                    }
                } catch (Exception ex) {
                    //In thong tin chi tiet ve exception trong cua so Output de nguoi lap trinh xem
                    ex.printStackTrace();
                    //Quay ve trang chu & thong bao loi
                    Alert alert = new Alert("danger", "Checkout error", "Please check your information.");
                    session.setAttribute("alert", alert);
                    response.sendRedirect(request.getContextPath() + "/cart/index.do?alert=1");
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
