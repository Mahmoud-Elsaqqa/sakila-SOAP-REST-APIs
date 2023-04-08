package gov.iti.jets.repository;


import gov.iti.jets.model.dto.core.StaffModel;
import gov.iti.jets.model.dto.extra.StaffDetailsModel;

import java.util.List;
import java.util.Optional;

public interface StaffRepository extends CrudRepository<StaffModel, Integer> {
    List<StaffDetailsModel> findAllStaffDetailsList();

    Optional<StaffDetailsModel> findStaffDetailsById(Integer staffId);
}
