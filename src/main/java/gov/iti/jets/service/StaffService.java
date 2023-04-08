package gov.iti.jets.service;


import gov.iti.jets.model.dto.core.StaffModel;
import gov.iti.jets.model.dto.extra.StaffDetailsModel;

import java.util.List;
import java.util.Optional;

public interface StaffService {
    List<StaffModel> getStaffList();

    Optional<StaffModel> getStaff(String staffId);

    List<StaffDetailsModel> getStaffDetailsList();

    Optional<StaffDetailsModel> getStaffDetails(String staffId);

    StaffModel addStaff(StaffModel model);

    StaffModel updateStaff(String staffId, StaffModel model);

    void removeStaff(String staffId);
}
