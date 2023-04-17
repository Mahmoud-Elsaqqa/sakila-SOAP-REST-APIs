package gov.iti.jets.repository;


import gov.iti.jets.model.dto.rental.StaffModel;
import gov.iti.jets.model.dto.extra.StaffDetailsModel;
import gov.iti.jets.model.entity.rental.StaffEntity;

import java.util.List;
import java.util.Optional;

public class StaffRepository extends CrudRepositoryImpl<StaffEntity, Integer> {

    public StaffRepository(Class<StaffEntity> entityClass) {
        super(entityClass);
    }

//    List<StaffDetailsModel> findAllStaffDetailsList();
//
//    Optional<StaffDetailsModel> findStaffDetailsById(Integer staffId);
}
