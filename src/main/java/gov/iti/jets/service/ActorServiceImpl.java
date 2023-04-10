package gov.iti.jets.service;

import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.mapping.mapper.ActorMapper;
import gov.iti.jets.repository.ActorRepositoryImpl;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class ActorServiceImpl implements CrudServices<ActorModel, Integer> {
    ActorRepositoryImpl repository = new ActorRepositoryImpl();
    ActorMapper mapper = ActorMapper.INSTANCE;

    @Override
    public List<ActorModel> findAll() {
        return mapper.mapToDtoList(repository.findAll());
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(ActorModel dto) {
        repository.delete(mapper.mapToEntity(dto));
    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public ActorModel findById(Integer id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No such id"));
        return mapper.mapToDto(entity);
    }

    @Override
    public void save(ActorModel dto) {
        var entity = mapper.mapToEntity(dto);
        repository.save(entity);
    }

    @Override
    public void update(ActorModel dto) {
        var entity = mapper.mapToEntity(dto);
        repository.update(entity);
    }

    @Override
    public void updateById(Integer id) {
        repository.updateById(id);
    }
}
