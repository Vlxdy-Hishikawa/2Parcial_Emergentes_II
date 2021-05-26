package com.Vlxdy.controlador;


import com.Vlxdy.dao.RolDAOimpl;
import com.Vlxdy.modelo.Roles;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Vlxdy.dao.RolDAO;

@WebServlet(name = "RolControlador", urlPatterns = {"/RolControlador"})
public class RolControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Roles ro = new Roles();
            int id;
            RolDAO dao = new RolDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch(action){
                case "add":
                    request.setAttribute("rol", ro);
                    request.getRequestDispatcher("frmrol.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    ro =  dao.getById(id);
                    request.setAttribute("rol", ro);
                    request.getRequestDispatcher("frmrol.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("RolControlador");
                    break;
                case "view":
                    List<Roles> lista = dao.getAll();
                    request.setAttribute("rols",lista);
                    request.getRequestDispatcher("roles.jsp").forward(request, response);
                    break;
            }
            
        }catch(Exception ex){
            System.out.println("Error " + ex.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion =  request.getParameter("descripcion");
        
        Roles ro = new Roles();
        
        ro.setId(id);
        ro.setDescripcion(descripcion);
        
        RolDAO dao = new RolDAOimpl();
        if (id == 0){
            try {
                dao.insert(ro);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ex.getMessage());
            }
        }
        else{
            try {
                dao.update(ro);
            } catch (Exception ex) {
                System.out.println("Error al editar "+ex.getMessage());
            }
        }
        response.sendRedirect("RolControlador");
    }
}
