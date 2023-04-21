package gov.iti.jets.repository;


import gov.iti.jets.model.entity.rental.StoreEntity;

public class StoreRepository extends CrudRepositoryImpl<StoreEntity, Integer> {
    public StoreRepository(Class<StoreEntity> entityClass) {
        super(entityClass);
    }
}

//    List<StoreDetailsModel> findAllStoreDetailsList();
//
//    Optional<StoreDetailsModel> findStoreDetailsById(Integer storeId);
//
//    List<StaffModel> findAllStoreStaffList(Integer storeId);
//
//    Optional<StaffModel> findStoreStaffById(Integer storeId, Integer staffId);

