package gov.iti.jets.repository;


import gov.iti.jets.model.dto.rental.StaffModel;
import gov.iti.jets.model.dto.extra.StaffDetailsModel;

import java.util.List;
import java.util.Optional;

public interface StaffRepository  {
    List<StaffDetailsModel> findAllStaffDetailsList();

    Optional<StaffDetailsModel> findStaffDetailsById(Integer staffId);
}
