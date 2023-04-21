package gov.iti.jets.repository;

import gov.iti.jets.model.dto.rental.RentalModel;
import gov.iti.jets.model.entity.rental.RentalEntity;
import gov.iti.jets.service.CrudServiceImpl;
import gov.iti.jets.util.EntityManagerHelper;

import java.util.List;

public class RentalRepository extends CrudRepositoryImpl<RentalEntity, Integer> {

    public RentalRepository(Class entityClass) {
        super(entityClass);
    }

    public List<RentalEntity> getRentalsByCustomerId(Integer customerId) {
        return
                EntityManagerHelper.getEntityManager()
                        .createQuery("FROM rental r" +
                                " WHERE r.customerId = :id", RentalEntity.class)
                        .setParameter("id", customerId)
                        .getResultList();
    }

//    List<RentalModel> findAllRentalDetailsList();
//
//    Optional<RentalModel> findRentalDetailsById(Integer rentalId);
}
