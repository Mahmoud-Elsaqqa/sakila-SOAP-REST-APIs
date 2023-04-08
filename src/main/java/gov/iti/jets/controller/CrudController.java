package gov.iti.jets.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public interface CrudController<T> {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    T getById(@PathParam("id") String id);

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    List<T> list();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    T add(T resource);

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    T update(@PathParam("id") String id, T resource);

    @DELETE
    @Path("{id}")
    void delete(@PathParam("id") String id);

}
