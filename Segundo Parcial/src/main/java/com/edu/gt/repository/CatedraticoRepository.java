package com.edu.gt.repository;

import com.edu.gt.model.Catedratico;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CatedraticoRepository implements PanacheRepository<Catedratico> {

}
