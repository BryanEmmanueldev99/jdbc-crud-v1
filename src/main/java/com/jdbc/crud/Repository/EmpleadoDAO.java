package com.jdbc.crud.Repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Repository;

import com.jdbc.crud.model.Empleado;

@Repository
public interface EmpleadoDAO  {
    
        public boolean save(Empleado empleado);
        public List<Empleado> all(Pageable pageable);


}
