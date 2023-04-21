package gov.iti.jets.repository;


import gov.iti.jets.model.entity.rental.StaffEntity;

public class StaffRepository extends CrudRepositoryImpl<StaffEntity, Integer> {

    public StaffRepository(Class<StaffEntity> entityClass) {
        super(entityClass);
    }

//    List<StaffDetailsModel> findAllStaffDetailsList();
//
//    Optional<StaffDetailsModel> findStaffDetailsById(Integer staffId);
}
