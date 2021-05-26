package com.Vlxdy.dao;

import com.Vlxdy.modelo.Roles;
import java.util.List;

public interface RolDAO {
    public void insert(Roles roles) throws Exception;
    public void update(Roles roles) throws Exception;
    public void delete(int id) throws Exception;
    public Roles getById(int id) throws Exception;
    public List<Roles> getAll() throws Exception;    
}
