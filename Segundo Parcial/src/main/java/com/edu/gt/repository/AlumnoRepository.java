package com.edu.gt.repository;

import com.edu.gt.model.Alumno;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AlumnoRepository implements PanacheRepository<Alumno> {

}
