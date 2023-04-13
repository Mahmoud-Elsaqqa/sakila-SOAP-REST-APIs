package gov.iti.jets.controller;

import gov.iti.jets.model.dto.BaseDto;
import gov.iti.jets.service.CrudService;

import java.util.List;

public class CrudControllerImpl<T extends BaseDto> implements CrudController<T> {

    CrudService<T, Integer> service;

    public CrudControllerImpl(CrudService<T, Integer> service) {
        this.service = service;
    }

    public List<T> findAll() {
        return service.findAll();
    }

    public void deleteById(Integer id) {
        service.deleteById(id);
    }

    public void delete(T dto) {
        service.delete(dto);
    }

    public boolean existsById(Integer id) {
        return service.existsById(id);
    }

    public long count() {
        return service.count();
    }

    public T findById(Integer id) {
        return service.findById(id);
    }

    public void save(T dto) {
        service.save(dto);
    }

    public void update(T dto) {
        service.update(dto);
    }

    public void updateById(Integer id) {
        service.updateById(id);
    }
}
