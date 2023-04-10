package gov.iti.jets.repository;


import gov.iti.jets.model.dto.rental.StaffModel;
import gov.iti.jets.model.dto.rental.StoreModel;
import gov.iti.jets.model.dto.extra.StoreDetailsModel;

import java.util.List;
import java.util.Optional;

public interface StoreRepository  {
    List<StoreDetailsModel> findAllStoreDetailsList();

    Optional<StoreDetailsModel> findStoreDetailsById(Integer storeId);

    List<StaffModel> findAllStoreStaffList(Integer storeId);

    Optional<StaffModel> findStoreStaffById(Integer storeId, Integer staffId);
}
