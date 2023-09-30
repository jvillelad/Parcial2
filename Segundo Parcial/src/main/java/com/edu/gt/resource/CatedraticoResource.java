package com.edu.gt.resource;

import com.edu.gt.dto.CatedraticoDto;
import com.edu.gt.model.Catedratico;
import com.edu.gt.repository.CatedraticoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/catedratico")
public class CatedraticoResource {

    @Inject
    private CatedraticoRepository repo;

    @GET
    public List<Catedratico> index(){
        return repo.listAll();
    }

    @POST
    public Response insert(CatedraticoDto c){
        try{
            Catedratico catedratico = convertDtoToEntity(c);
            repo.persist(catedratico);
            return Response.ok(c).build();
        }catch (Exception e){
            return Response.status(400).build();
        }
    }

    public Catedratico convertDtoToEntity(CatedraticoDto c){
        Catedratico catedratico = new Catedratico();
        catedratico.setCodigoCatedratico(c.getCodigoCatedratico());
        catedratico.setNombre(c.getNombre());
        catedratico.setDireccion(c.getDireccion());
        catedratico.setTelefono(c.getTelefono());
        catedratico.setProfesion(c.getProfesion());

        return catedratico;
    }
}