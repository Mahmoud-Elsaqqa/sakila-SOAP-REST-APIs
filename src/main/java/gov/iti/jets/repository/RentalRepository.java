package gov.iti.jets.repository;

import gov.iti.jets.model.dto.rental.RentalModel;

import java.util.List;
import java.util.Optional;

public interface RentalRepository {
    List<RentalModel> findAllRentalDetailsList();

    Optional<RentalModel> findRentalDetailsById(Integer rentalId);
}
