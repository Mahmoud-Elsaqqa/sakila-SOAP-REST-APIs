package gov.iti.jets.controller.rest;


import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.dto.BaseRequestModel;
import gov.iti.jets.model.entity.BaseEntity;
import gov.iti.jets.service.CrudService;
import gov.iti.jets.service.CrudServiceImpl;
import jakarta.ws.rs.core.Response;

import java.util.List;

public abstract class CrudControllerImpl<E extends BaseEntity, M extends BaseModel, R extends BaseRequestModel> implements CrudController<M, R> {

    CrudService<E, M, R, Integer> service;

    public CrudControllerImpl(CrudServiceImpl<E, M, R, Integer> service) {
        this.service = service;
    }

    public List<M> findAll() {
        return service.findAll();
    }

    public void deleteById(Integer id) {
        service.deleteById(id);
    }


    public Response existsById(Integer id) {
        if (service.existsById(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    public long count() {
        return service.count();
    }

    public M findById(Integer id) {
        return service.findById(id);
    }

    public void save(R requestDto) {
        service.save(requestDto);
    }

    public void update(Integer id, R requestDto) {
        service.update(id, requestDto);
    }

}
