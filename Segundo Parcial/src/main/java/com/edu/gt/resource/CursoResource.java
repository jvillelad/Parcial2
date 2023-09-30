package com.edu.gt.resource;

import com.edu.gt.dto.CursoDto;
import com.edu.gt.model.Catedratico;
import com.edu.gt.model.Curso;
import com.edu.gt.repository.CursoRepository;
import com.edu.gt.repository.CatedraticoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/curso")
public class CursoResource {

    @Inject
    private CursoRepository cursoRepo;

    @Inject
    private CatedraticoRepository catedraticoRepo;

    @GET
    public List<Curso> index(){
        return cursoRepo.listAll();
    }

    @POST
    public Response insert(CursoDto c){
        try{
            Curso curso = convertDtoToEntity(c);
            if (curso.getCatedratico() == null) {
                return Response.status(400).entity("El catedrático especificado no existe").build();
            }
            cursoRepo.persist(curso);
            return Response.ok(c).build();
        }catch (Exception e){
            return Response.status(400).build();
        }
    }

    public Curso convertDtoToEntity(CursoDto c){
        Curso curso = new Curso();
        curso.setId(c.getId());
        curso.setTitulo(c.getTitulo());
        curso.setNumMaxAlumnos(c.getNumMaxAlumnos());
        curso.setCreditos(c.getCreditos());
        Catedratico catedratico = catedraticoRepo.findById((long) c.getCatedraticoCodigo());
        if (catedratico != null) {
            curso.setCatedratico(catedratico);
        }

        return curso;
    }
}
