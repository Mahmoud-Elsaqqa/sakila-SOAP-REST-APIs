package gov.iti.jets.repository;

import gov.iti.jets.model.dto.core.RentalModel;

import java.util.List;
import java.util.Optional;

public interface RentalRepository extends CrudRepository<RentalModel, Integer>{
    List<RentalModel> findAllRentalDetailsList();

    Optional<RentalModel> findRentalDetailsById(Integer rentalId);
}
