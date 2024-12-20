package com.jdbc.crud.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Empleado {

    private int id;
    private String nombre;
    private String email;
    private float salario;
    private String direccion;

}
