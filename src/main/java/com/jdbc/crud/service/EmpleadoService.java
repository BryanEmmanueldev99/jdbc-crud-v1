package com.jdbc.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jdbc.crud.Repository.EmpleadoDAO;
import com.jdbc.crud.model.Empleado;

public class EmpleadoService implements EmpleadoDAO {
   
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(Empleado empleado) {
        try {  
            String sql = String.format
            ("INSERT INTO empleados(nombre, email, salario, direccion) " 
            + "values ('%s', '%s', '%d', '%s')", 
            empleado.getNombre(), empleado.getEmail(),
            empleado.getSalario(), empleado.getDireccion());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Empleado> all(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'all'");
    }

}
