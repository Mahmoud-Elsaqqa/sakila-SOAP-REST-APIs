package gov.iti.jets.controller.rest;

import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.dto.BaseRequestModel;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

public interface CrudController<M extends BaseModel, R extends BaseRequestModel> {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    List<M> findAll();

    @DELETE
    @Path("/{id}")
    void deleteById(@PathParam("id") Integer id);

    @HEAD
    @Path("/{id}")
    Response existsById(@PathParam("id") Integer id);

    @GET
    @Path("/count")
    long count();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    M findById(@PathParam("id") Integer id);

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    void save(R requestDto);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    void update(@PathParam("id") Integer id, R requestDto);

}



