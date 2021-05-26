package com.Vlxdy.controlador;

import com.Vlxdy.dao.UsuarioDAOimpl;
import com.Vlxdy.dao.RolDAOimpl;
import com.Vlxdy.dao.PermisoDAOimpl;
import com.Vlxdy.modelo.Usuario;
import com.Vlxdy.modelo.Roles;
import com.Vlxdy.modelo.Permiso;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Vlxdy.dao.UsuarioDAO;
import com.Vlxdy.dao.RolDAO;
import com.Vlxdy.dao.PermisoDAO;

@WebServlet(name = "PermisoControlador", urlPatterns = {"/PermisoControlador"})
public class PermisoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            PermisoDAO dao = new PermisoDAOimpl();
            UsuarioDAO daoUsuario = new UsuarioDAOimpl();
            RolDAO daoRol = new RolDAOimpl();
            int id;
            
            List<Usuario> lista_usuarios = null;
            List<Roles> lista_roles = null;
            
            Permiso per = new Permiso();
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            System.out.println("Opcion = "+ action);
            switch(action){
                case "add":
                    lista_usuarios = daoUsuario.getAll();
                    lista_roles = daoRol.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("lista_roles", lista_roles);
                    request.setAttribute("permiso",per);
                    request.getRequestDispatcher("frmpermiso.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    per = dao.getById(id);
                    lista_usuarios = daoUsuario.getAll();
                    lista_roles = daoRol.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("lista_roles", lista_roles);
                    request.setAttribute("permiso",per);
                    request.getRequestDispatcher("frmpermiso.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("PermisoControlador");
                    break;
                case "view":
                    List<Permiso> lista = dao.getAll();
                    request.setAttribute("permisos", lista);
                    request.getRequestDispatcher("permiso.jsp").forward(request, response);
                    break;
            }
        }catch(Exception ex){
            System.out.println("Error fatal " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        int id_rol = Integer.parseInt(request.getParameter("id_rol"));
        
        Permiso permiso = new Permiso();
        
        permiso.setId(id);
        permiso.setId_usuario(id_usuario);
        permiso.setId_rol(id_rol);
        
        if(id == 0){
            PermisoDAO dao = new PermisoDAOimpl();
            try {
                dao.insert(permiso);
                response.sendRedirect("PermisoControlador");
            } catch (Exception ex) {
                Logger.getLogger(PermisoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            PermisoDAO dao = new PermisoDAOimpl();
            try {
                dao.update(permiso);
                response.sendRedirect("PermisoControlador");
            } catch (Exception ex) {
                Logger.getLogger(PermisoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }
}
