package gov.iti.jets.service;

import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.dto.BaseRequestModel;
import gov.iti.jets.model.entity.BaseEntity;
import gov.iti.jets.model.mapping.mapper.BaseMapper;
import gov.iti.jets.repository.CrudRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class CrudServiceImpl<E extends BaseEntity, M extends BaseModel, R extends BaseRequestModel, K> implements CrudService<E, M, R, K> {


    CrudRepository<E, K> repository;
    BaseMapper<E, M, R> mapper;

    public CrudServiceImpl(CrudRepository<E, K> repository, BaseMapper<E, M, R> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<M> findAll() {
        return mapper.mapToDtoList(repository.findAll());
    }

    @Override
    public void deleteById(K id) {
        repository.deleteById(id);
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
    public M findById(K id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No such id"));
        return mapper.mapToDto(entity);
    }

    @Override
    public void save(R requestDto) {
        var entity = mapper.mapToEntity(requestDto);
        repository.save(entity);
    }

    @Override
    public void update(K id, R requestDto) {
        var entity = mapper.mapToEntity(requestDto);
        repository.update(id, entity);
    }

}
