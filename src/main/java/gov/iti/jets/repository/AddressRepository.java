package gov.iti.jets.repository;


import gov.iti.jets.model.dto.core.AddressModel;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends CrudRepository<AddressModel, Integer> {
    List<AddressModel> findAllAddressDetailsList();

    Optional<AddressModel> findAddressDetailsById(Integer addressId);
}
