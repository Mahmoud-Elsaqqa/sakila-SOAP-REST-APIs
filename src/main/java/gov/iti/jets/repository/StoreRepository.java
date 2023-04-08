package gov.iti.jets.repository;


import gov.iti.jets.model.dto.core.StaffModel;
import gov.iti.jets.model.dto.core.StoreModel;
import gov.iti.jets.model.dto.extra.StoreDetailsModel;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends CrudRepository<StoreModel, Integer> {
    List<StoreDetailsModel> findAllStoreDetailsList();

    Optional<StoreDetailsModel> findStoreDetailsById(Integer storeId);

    List<StaffModel> findAllStoreStaffList(Integer storeId);

    Optional<StaffModel> findStoreStaffById(Integer storeId, Integer staffId);
}
