package gov.iti.jets.service;


import gov.iti.jets.model.dto.core.RentalModel;

import java.util.List;
import java.util.Optional;

public interface RentalService {

    List<RentalModel> getRentalList();

    Optional<RentalModel> getRental(String rentalId);

    List<RentalModel> getRentalDetailsList();

    Optional<RentalModel> getRentalDetails(String rentalId);

    RentalModel addRental(RentalModel model);

    RentalModel updateRental(String rentalId, RentalModel model);

    void deleteRental(String rentalId);
}
