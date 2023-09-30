package com.edu.gt.dto;

import lombok.Getter;
import lombok.Setter;

public class AlumnoDto {
    private int carnet;
    @Getter
    private String nombre;
    @Getter @Setter
    private String direccion;
    @Getter @Setter
    private String telefono;
    @Getter @Setter
    private int edad;

    public int getCarnet() {
        return carnet;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }
}
