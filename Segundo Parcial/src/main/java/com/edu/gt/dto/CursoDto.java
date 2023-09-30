package com.edu.gt.dto;

import lombok.Data;

@Data
public class CursoDto {
    private int id;
    private String titulo;
    private int numMaxAlumnos;
    private int creditos;
    private int catedraticoCodigo;
}
