package gov.iti.jets.soap;


import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.dto.BaseRequestModel;
import gov.iti.jets.model.entity.BaseEntity;
import gov.iti.jets.service.CrudService;
import gov.iti.jets.service.CrudServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public abstract class CrudWSImpl<E extends BaseEntity, M extends BaseModel, R extends BaseRequestModel> implements CrudWS<M, R> {

    CrudService<E, M, R, Integer> service;

    public CrudWSImpl(CrudServiceImpl<E, M, R, Integer> service) {
        this.service = service;
    }

    @WebMethod
    public List<M> findAll() {
        return service.findAll();
    }

    @WebMethod
    public void deleteById(Integer id) {
        service.deleteById(id);
    }

    @WebMethod
    public boolean existsById(Integer id) {
        return service.existsById(id);
    }

    @WebMethod
    public long count() {
        return service.count();
    }

    @WebMethod
    public M findById(Integer id) {
        return service.findById(id);
    }

    @WebMethod
    public void save(R requestDto) {
        service.save(requestDto);
    }

    @WebMethod
    public void update(Integer id, R requestDto) {
        service.update(id, requestDto);
    }
}
