package com.Vlxdy.dao;

import com.Vlxdy.modelo.Permiso;
import java.util.List;

public interface PermisoDAO {
    public void insert(Permiso permiso) throws Exception;
    public void update(Permiso permiso) throws Exception;
    public void delete(int id) throws Exception;
    public Permiso getById(int id) throws Exception;
    public List<Permiso> getAll() throws Exception;       
}
