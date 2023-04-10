package gov.iti.jets.repository;

import gov.iti.jets.model.entity.inventory.ActorEntity;
import gov.iti.jets.util.EntityManagerHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

public class ActorRepositoryImpl implements CrudRepository<ActorEntity> {

    @Override
    public List<ActorEntity> findAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void delete(ActorEntity entity) {

    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Optional<ActorEntity> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(ActorEntity entity) {

    }

    @Override
    public void update(ActorEntity entity) {

    }
}
