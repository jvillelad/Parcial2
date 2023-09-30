package com.edu.gt.resource;

import com.edu.gt.dto.AlumnoDto;
import com.edu.gt.model.Alumno;
import com.edu.gt.repository.AlumnoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/alumno")
public class AlumnoResource {


    @Inject
    private AlumnoRepository repo;

    @GET
    public List<Alumno> index(){
        return repo.listAll();
    }

    @POST
    public Response insert(AlumnoDto a){
        try{
            Alumno alumno = convertDtoToEntity(a);
            repo.persist(alumno);
            return Response.ok(a).build();
        }catch (Exception e){
            return Response.status(400).build();
        }
    }

    public Alumno convertDtoToEntity(AlumnoDto a){
        Alumno alumno = new Alumno();
        alumno.setCarnet(a.getCarnet());
        alumno.setNombre(a.getNombre());
        alumno.setDireccion(a.getDireccion());
        alumno.setTelefono(a.getTelefono());
        alumno.setEdad(a.getEdad());

        return alumno;
    }
}
