package gov.iti.jets.service;

import gov.iti.jets.model.dto.StaffRequestModel;
import gov.iti.jets.model.dto.rental.StaffModel;
import gov.iti.jets.model.entity.rental.StaffEntity;
import gov.iti.jets.model.mapping.mapper.BaseMapper;
import gov.iti.jets.model.mapping.mapper.StaffMapper;
import gov.iti.jets.repository.CrudRepository;
import gov.iti.jets.repository.StaffRepository;

public class StaffServiceImpl extends CrudServiceImpl<StaffEntity, StaffModel, StaffRequestModel, Integer> {
    public static final StaffRepository repository= new StaffRepository(StaffEntity.class);
    public static final StaffMapper mapper = StaffMapper.INSTANCE;

    public StaffServiceImpl() {
        super(repository, mapper);
    }
}
