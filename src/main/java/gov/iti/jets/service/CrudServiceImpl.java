package gov.iti.jets.service;

import gov.iti.jets.model.dto.BaseDto;
import gov.iti.jets.model.dto.BaseDto;
import gov.iti.jets.model.entity.BaseEntity;
import gov.iti.jets.model.mapping.mapper.BaseMapper;
import gov.iti.jets.repository.CrudRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class CrudServiceImpl<T extends BaseDto, U extends BaseEntity, K> implements CrudService<T, K> {


    CrudRepository<U, K> repository;
    BaseMapper<U, T> mapper;

    public CrudServiceImpl(CrudRepository<U, K> repository, BaseMapper<U, T> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<T> findAll() {
        return mapper.mapToDtoList(repository.findAll());
    }

    @Override
    public void deleteById(K id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(T dto) {
        repository.delete(mapper.mapToEntity(dto));
    }

    @Override
    public boolean existsById(K id) {
        return repository.existsById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public T findById(K id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No such id"));
        return mapper.mapToDto(entity);
    }

    @Override
    public void save(T dto) {
        var entity = mapper.mapToEntity(dto);
        repository.save(entity);
    }

    @Override
    public void update(T dto) {
        var entity = mapper.mapToEntity(dto);
        repository.update(entity);
    }

    @Override
    public void updateById(K integer) {

    }
}
