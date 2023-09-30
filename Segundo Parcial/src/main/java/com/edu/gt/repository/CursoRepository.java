package com.edu.gt.repository;

import com.edu.gt.model.Curso;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CursoRepository implements PanacheRepository<Curso> {

}