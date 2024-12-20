package com.jdbc.crud.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jdbc.crud.model.Empleado;

@Controller
public class EmpleadoController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // @GetMapping("/test")
    // public void testjdbc()
    // {
    // jdbcTemplate.execute("INSERT INTO empleados(nombre) values ('java')");
    // }

    @GetMapping("/empleados")
    public String getEmployees(Model model) {
        String sql = "SELECT * FROM empleados";
        List<Empleado> employees = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Empleado.class));
        String ms = "Jesus";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        Calendar cal = Calendar.getInstance();
        String today = dateFormat.format(cal.getTime());

        // asi se pueden pasar variables a thymleaf
        model.addAttribute("empleados", employees);
        model.addAttribute("m", ms);
        model.addAttribute("today", today);

        return "empleados";
    }

    @GetMapping("/empleados/create")
    public String viewCreate(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "create";
    }

    @PostMapping("/empleados")
    public String store(Empleado empleado, Model model) {
        String insertQuery = "INSERT INTO empleados(empleado_id, nombre, email, salario, direccion) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(insertQuery, empleado.getId(), empleado.getNombre(), empleado.getEmail(),
                empleado.getSalario(), empleado.getDireccion());
        return "redirect:/empleados";
    }

    @GetMapping("/empleado/{id}")
    public String getEmpleado(@PathVariable("id") int id, Model model) { 
        
        String sql = "SELECT * FROM empleados WHERE id = ?";
        Object[]args = {id};
		Empleado empleado = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Empleado.class));
        model.addAttribute("empleado", empleado);
        return "empleado";
    }

}
