/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cart.Cart;
import db.Account;
import db.AccountFacade;
import db.Customer;
import db.CustomerFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Alert;
import utils.Hash;

/**
 *
 * @author PHT
 */
@WebServlet(name = "AccountController", urlPatterns = {"/account"})
public class AccountController extends HttpServlet {

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

        //Lấy tham chiếu của session
        HttpSession session = request.getSession();
        switch (action) {
            case "login":
                try {
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    AccountFacade af = new AccountFacade();
                    Account account = af.login(email, Hash.hash(password));
                    if (account != null) {
                        session.setAttribute("account", account);
                        String oldUrl = (String) session.getAttribute("oldUrl");
                        if (oldUrl == null) {
                            //Quay về home page
                            response.sendRedirect(request.getContextPath() + "/home/index.do");
                        } else {
                            session.removeAttribute("oldUrl");
                            response.sendRedirect(request.getContextPath() + oldUrl);
                        }
                    } else {
                        Alert alert = new Alert("danger", "Login Error", "Please check your email or password");
                        session.setAttribute("alert", alert);
                        //Quay về home page & thông báo lỗi
                        response.sendRedirect(request.getContextPath() + "/home/index.do?alert=1");
                    }
                } catch (Exception ex) {
                    //In thong tin chi tiet ve exception trong cua so Output de nguoi lap trinh xem
                    ex.printStackTrace();
                    //Chuyen den trang thong bao loi
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            case "logout":
                try {
                    //Xóa các thông tin lưu trong session
                    session.invalidate();
                    response.sendRedirect(request.getContextPath() + "/home/index.do");
                } catch (Exception ex) {
                    //In thong tin chi tiet ve exception trong cua so Output de nguoi lap trinh xem
                    ex.printStackTrace();
                    //Chuyen den trang thong bao loi
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            case "register"://Hiện view để khách hàng nhập thông tin đăng ký 
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
            case "register_handler"://Xử lý form đăng ký khách hàng  
                try {
                    String name = request.getParameter("name");
                    String address = request.getParameter("address");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    String shipToAddress = request.getParameter("shipToAddress");

                    Customer customer = new Customer(name, address, phone, email, password, true, "ROLE_CUSTOMER", "Copper", shipToAddress);
                    CustomerFacade cf = new CustomerFacade();
                    cf.register(customer);

                    //Quay về home page & thông báo
                    Alert alert = new Alert("success", "Register Customer", "Register new customer successfully.");
                    session.setAttribute("alert", alert);
                    response.sendRedirect(request.getContextPath() + "/home/index.do?alert=1");
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
