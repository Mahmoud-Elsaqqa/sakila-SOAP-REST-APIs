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

public class ActorRepositoryImpl implements CrudRepository<ActorEntity, Integer> {

    @Override
    public List<ActorEntity> findAll() {
        EntityManager entityManager = EntityManagerHelper.getEntityManager();
        TypedQuery<ActorEntity> typedQuery = entityManager
                .createQuery("from actor", ActorEntity.class);
        return typedQuery.getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        try (EntityManager entityManager = EntityManagerHelper.getEntityManager()) {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete<ActorEntity> delete = criteriaBuilder.createCriteriaDelete(ActorEntity.class);
            Root<ActorEntity> actorEntityRoot = delete.from(ActorEntity.class);
            delete.where(criteriaBuilder.equal(actorEntityRoot.get("actorId"), id));
            entityManager.createQuery(delete).executeUpdate();
        } catch (Exception e) {
            EntityManagerHelper.rollback();
            throw new PersistenceException("Couldn't delete Actor");
        }
    }

    @Override
    public void delete(ActorEntity entity) {
        try (EntityManager entityManager = EntityManagerHelper.getEntityManager()) {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete<ActorEntity> delete = criteriaBuilder.createCriteriaDelete(ActorEntity.class);
            Root<ActorEntity> actorEntityRoot = delete.from(ActorEntity.class);
            delete(entity);
            entityManager.createQuery(delete).executeUpdate();
        } catch (Exception e) {
            EntityManagerHelper.rollback();
            throw new PersistenceException("Couldn't delete Actor");
        }
    }

    @Override
    public boolean existsById(Integer id) {
        EntityManager entityManager = EntityManagerHelper.getEntityManager();
        TypedQuery<Long> typedQuery = entityManager
                .createQuery("SELECT count(a) FROM actor a WHERE actorId=:id", Long.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult() > 0;
    }

    @Override
    public long count() {
        EntityManager entityManager = EntityManagerHelper.getEntityManager();
        TypedQuery<Long> typedQuery = entityManager
                .createQuery("SELECT count(a) FROM actor a", Long.class);
        return typedQuery.getSingleResult();
    }

    @Override
    public Optional<ActorEntity> findById(Integer id) {
        EntityManager entityManager = EntityManagerHelper.getEntityManager();
        TypedQuery<ActorEntity> typedQuery = entityManager
                .createQuery("from actor where actorId=:id", ActorEntity.class);
        typedQuery.setParameter("id", id);
        ActorEntity entity = typedQuery.getSingleResult();
        return Optional.ofNullable(entity);
    }

    @Override
    public void save(ActorEntity entity) {
        try (EntityManager entityManager = EntityManagerHelper.getEntityManager()) {
            EntityManagerHelper.beginTransaction();
            entityManager.persist(entity);
            EntityManagerHelper.commit();
        } catch (Exception e) {
            EntityManagerHelper.rollback();
        }
    }

    @Override
    public void update(ActorEntity entity) {
        try (EntityManager entityManager = EntityManagerHelper.getEntityManager()) {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaUpdate<ActorEntity> update = criteriaBuilder.createCriteriaUpdate(ActorEntity.class);
            Root<ActorEntity> actorEntityRoot = update.from(ActorEntity.class);
            update(entity);
            entityManager.createQuery(update).executeUpdate();
        } catch (Exception e) {
            EntityManagerHelper.rollback();
            throw new PersistenceException("Couldn't delete Actor");
        }

    }

    @Override
    public void updateById(Integer id) {
        try (EntityManager entityManager = EntityManagerHelper.getEntityManager()) {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaUpdate<ActorEntity> update = criteriaBuilder.createCriteriaUpdate(ActorEntity.class);
            Root<ActorEntity> actorEntityRoot = update.from(ActorEntity.class);
            update.where(criteriaBuilder.equal(actorEntityRoot.get("actorId"), id));
            entityManager.createQuery(update).executeUpdate();
        } catch (Exception e) {
            EntityManagerHelper.rollback();
            throw new PersistenceException("Couldn't delete Actor");
        }

    }
}
