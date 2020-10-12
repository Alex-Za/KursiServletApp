package server;

import beans.CountryBean;
import beans.VendorBean;
import dao.CountryDAO;
import dao.VendorDAO;
import exception.CantFindVendorException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "VendorServlet", urlPatterns = {"/vendors"})
public class VendorServlet extends HttpServlet {
    @Resource(name = "jdbc/watches")
    DataSource ds;
    Connection connection;
    private VendorDAO vendorDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            connection = ds.getConnection();
            vendorDAO = new VendorDAO(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        VendorBean vendorBean = new VendorBean();
        try {
            vendorBean.setVendors(vendorDAO.findById(id));
        } catch (CantFindVendorException e) {
            e.printStackTrace();
        }

        request.setAttribute("vendorBean", vendorBean);
        request.getRequestDispatcher("/showvendors.jsp").forward(request, response);
    }
}
