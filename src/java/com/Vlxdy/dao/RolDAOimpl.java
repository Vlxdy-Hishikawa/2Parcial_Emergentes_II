package com.Vlxdy.dao;

import com.Vlxdy.modelo.Roles;
import com.Vlxdy.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RolDAOimpl extends ConexionDB implements RolDAO {

    @Override
    public void insert(Roles roles) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO roles (descripcion) values (?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, roles.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }        
    }

    @Override
    public void update(Roles roles) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE roles SET descripcion=? WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, roles.getDescripcion());
            ps.setInt(2, roles.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }           
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM roles WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1,id );
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }          
    }

    @Override
    public Roles getById(int id) throws Exception {
        Roles pro = new Roles();
        try {
            this.conectar();
            String sql = "SELECT * FROM roles WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                pro.setId(rs.getInt("id"));
                pro.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }   
        return pro;
    }

    @Override
    public List<Roles> getAll() throws Exception {
        List<Roles> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM roles";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Roles>();
            while (rs.next()){
                Roles p =  new Roles();
                p.setId(rs.getInt("id"));
                p.setDescripcion(rs.getString("descripcion"));
                lista.add(p);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }  
        return lista;
    }
    
}
