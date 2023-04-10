package gov.iti.jets.repository;


import gov.iti.jets.model.dto.customer.AddressModel;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {
    List<AddressModel> findAllAddressDetailsList();

    Optional<AddressModel> findAddressDetailsById(Integer addressId);
}
