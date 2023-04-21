package gov.iti.jets.repository;

import gov.iti.jets.model.entity.BaseEntity;
import gov.iti.jets.util.EntityManagerHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * This is a Generic Implementation to the basic CRUD Operations
 * The General CRUD Operations are provided in the {@link CrudRepository} Interface
 * <p>
 * The purpose of this class is to provide a single implementation template
 * for all JPA CRUD operations for all Entities
 * Avoiding Boilerplate code in EntityRepositories
 * each EntityRepository just needs to extend this class and calls its' super constructor whith its' class
 */
public abstract class CrudRepositoryImpl<T extends BaseEntity, K> implements CrudRepository<T, K> {

    private final Class<T> entityClass;

    public CrudRepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<T> findAll() {
        EntityManager entityManager = EntityManagerHelper.getEntityManager();
        return entityManager
                .createQuery("FROM " + entityClass.getCanonicalName(), entityClass)
                .getResultList();
    }

    @Override
    public boolean existsById(K id) {
        EntityManager entityManager = EntityManagerHelper.getEntityManager();
        return entityManager.find(entityClass, id) != null;

    }

    @Override
    public long count() {
        EntityManager entityManager = EntityManagerHelper.getEntityManager();
        TypedQuery<Long> query = entityManager
                .createQuery("SELECT COUNT(e) FROM " + entityClass.getCanonicalName() + " e", Long.class);
        return query.getSingleResult();

    }

    @Override
    public Optional<T> findById(K id) {
        EntityManager entityManager = EntityManagerHelper.getEntityManager();
        return Optional.ofNullable(entityManager.find(entityClass, id));

    }

    @Override
    public void delete(T entity) {
        executeInTransaction(entityManager -> {
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        }, "Couldn't delete row");
    }

    @Override
    public void deleteById(K id) {
        executeInTransaction(entityManager -> {
            T entity = entityManager.find(entityClass, id);
            if (entity != null) {
                entityManager.remove(entity);
            }
        }, "Couldn't delete row");
    }

    @Override
    public void save(T entity) {
        executeInTransaction(entityManager -> {
            entityManager.persist(entity);
        }, "Couldn't save entity");
    }

    @Override
    public void update(K id, T entity) {
        executeInTransaction(entityManager -> {
            T t = entityManager.getReference(entityClass, id);
            t.update(entity);
            entityManager.merge(t);
        }, "Couldn't update entity");
    }


    /**
     * The method takes care of the boilerplate code related to transaction management and error handling.
     */
    private void executeInTransaction(Consumer<EntityManager> entityManagerConsumer, String errorMessage) {
        EntityManager entityManager = EntityManagerHelper.getEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManagerConsumer.accept(entityManager);
            transaction.commit();
        } catch (Exception e) {
            EntityManagerHelper.rollback();
            throw new PersistenceException(errorMessage, e);
        }
    }
}