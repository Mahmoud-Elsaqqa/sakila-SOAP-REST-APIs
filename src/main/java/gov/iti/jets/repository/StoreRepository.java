package gov.iti.jets.repository;


import gov.iti.jets.model.dto.rental.StaffModel;
import gov.iti.jets.model.dto.rental.StoreModel;
import gov.iti.jets.model.dto.extra.StoreDetailsModel;
import gov.iti.jets.model.entity.rental.StoreEntity;
import gov.iti.jets.model.mapping.mapper.BaseMapper;
import gov.iti.jets.service.CrudServiceImpl;

import java.util.List;
import java.util.Optional;

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

