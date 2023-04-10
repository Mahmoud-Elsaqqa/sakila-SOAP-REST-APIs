package gov.iti.jets.repository;


import gov.iti.jets.model.dto.customer.CityModel;

import java.util.List;
import java.util.Optional;

public interface  CityRepository {
    List<CityModel> findAllCityDetailsList();

    Optional<CityModel> findCityDetailsById(Integer cityId);
}
