package gov.iti.jets.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public interface CrudController<T> {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    List<T> findAll();

    @DELETE
    @Path("/{id}")
    void deleteById(@PathParam("id") Integer id);

    @DELETE
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    void delete(T dto);

    @HEAD
    @Path("/{id}")
    boolean existsById(@PathParam("id") Integer id);

    @GET
    @Path("/count")
    long count();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    T findById(@PathParam("id") Integer id);

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    void save(T dto);

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    void update(T dto);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    void updateById(@PathParam("id") Integer id);
}


