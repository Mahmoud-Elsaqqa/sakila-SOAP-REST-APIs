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

public class ActorRepositoryImpl extends CrudRepositoryImpl<ActorEntity, Integer> {

    public ActorRepositoryImpl(Class<ActorEntity> entityClass) {
        super(entityClass);
    }
}
