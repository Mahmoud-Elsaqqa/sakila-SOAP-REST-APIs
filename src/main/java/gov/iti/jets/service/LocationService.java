package gov.iti.jets.service;


import gov.iti.jets.model.dto.core.AddressModel;
import gov.iti.jets.model.dto.core.CityModel;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    List<AddressModel> getAddressList();

    Optional<AddressModel> getAddress(String addressId);

    List<AddressModel> getAddressDetailsList();

    Optional<AddressModel> getAddressDetails(String addressId);

    AddressModel addAddress(AddressModel model);

    AddressModel updateAddress(String addressId, AddressModel model);

    void deleteAddress(String addressId);

    List<CityModel> getCityList();

    Optional<CityModel> getCity(String cityId);

    List<CityModel> getCityDetailsList();

    Optional<CityModel> getCityDetails(String cityId);

    CityModel addCity(CityModel model);

    CityModel updateCity(String cityId, CityModel model);

    void deleteCity(String cityId);
}
