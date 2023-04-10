package gov.iti.jets.service;


import gov.iti.jets.model.dto.rental.StaffModel;
import gov.iti.jets.model.dto.rental.StoreModel;
import gov.iti.jets.model.dto.extra.StoreDetailsModel;

import java.util.List;
import java.util.Optional;

public interface StoreService {
    List<StoreModel> getStoreList();

    Optional<StoreModel> getStore(String storeId);

    List<StoreDetailsModel> getStoreDetailsList();

    Optional<StoreDetailsModel> getStoreDetails(String storeId);

    List<StaffModel> getStoreStaffList(String storeId);

    Optional<StaffModel> getStoreStaff(String storeId, String staffId);

    StoreModel addStore(StoreModel model);

    StaffModel addStoreStaff(String storeId, String staffId);

    StoreModel updateStore(String storeId, StoreModel model);

    StaffModel updateStoreStaff(String storeId, String staffId);

    void deleteStore(String storeId);

    void removeStoreStaff(String storeId, String staffId);
}
