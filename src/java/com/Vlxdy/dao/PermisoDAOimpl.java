package com.Vlxdy.dao;

import com.Vlxdy.modelo.Permiso;
import com.Vlxdy.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PermisoDAOimpl extends ConexionDB implements PermisoDAO {

    @Override
    public void insert(Permiso permiso) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO permisos (id_usuario, id_rol) values (?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ps.setInt(1, permiso.getId_usuario());
            ps.setInt(2, permiso.getId_rol());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Permiso permiso) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE permisos SET id_usuario = ?, id_rol = ? WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, permiso.getId_usuario());
            ps.setInt(2, permiso.getId_rol());
            ps.setInt(3, permiso.getId());
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
            String sql = "DELETE FROM permisos WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Permiso getById(int id) throws Exception {
        Permiso p = new Permiso();
        try {
            this.conectar();
            String sql = "SELECT * FROM permisos WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setId_usuario(rs.getInt("id_usuario"));
                p.setId_rol(rs.getInt("id_rol"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return p;
    }

    @Override
    public List<Permiso> getAll() throws Exception {
        List<Permiso> lista = null;
        try {
            this.conectar();
            String sql = "SELECT p.*, u.usuario as usuario, r.descripcion as rol FROM usuarios u ";
            sql += "LEFT JOIN permisos p ON u.id = p.id_usuario ";
            sql += "LEFT JOIN roles r ON p.id_rol=r.id";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Permiso>();
            while (rs.next()) {
                Permiso p = new Permiso();
                p.setId(rs.getInt("id"));
                p.setId_usuario(rs.getInt("id_usuario"));
                p.setId_rol(rs.getInt("id_rol"));
                p.setUsuario(rs.getString("usuario"));
                p.setRol(rs.getString("rol"));
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
