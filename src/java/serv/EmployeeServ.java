/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import DAOHibernate.DAOHibernate;
import hiber.Employee;
import hiber.Person;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;

/**
 *
 * @author noorr
 */
@WebServlet(name = "EmployeeServ", urlPatterns = {"/EmployeeServ"})
public class EmployeeServ extends HttpServlet {

    private SessionFactory factory;
    private DAOHibernate hiber;

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
        /* TODO output your page here. You may use following sample code. */
        hiber = new DAOHibernate();

        Employee emp = new Employee();
        emp.setName(request.getParameter("name"));
        emp.setAddress(request.getParameter("address"));
        emp.setEmail(request.getParameter("email"));
        emp.setPhone(request.getParameter("phone"));

        String operation = request.getParameter("operation");
        System.out.println("perform " + operation + " :");

        switch (operation) {
            case "Add":
                hiber.insertPerson(emp);
                break;

            case "Edit":
                emp.setId(parseInt(request.getParameter("id")));

                hiber.updateUser(emp);
                break;

            case "Delete":
                hiber.deletePerson(parseInt(request.getParameter("id")));
                break;

            case "Search":
                List<Person> persons = hiber.searchUser(request.getParameter("name"));
                request.setAttribute("list", persons);
                request.getRequestDispatcher("Person.jsp").forward(request, response);
                return;

            default:
                System.out.println("Error");
                break;
        }
        List<Person> person = hiber.selectUser();
        System.out.println("size is " + person.size());
        request.setAttribute("list", person);
        request.getRequestDispatcher("Person.jsp").forward(request, response);
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
