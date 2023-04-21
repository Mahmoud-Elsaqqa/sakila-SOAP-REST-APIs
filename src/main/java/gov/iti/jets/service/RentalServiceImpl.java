package gov.iti.jets.service;

import gov.iti.jets.model.dto.request.RentalRequestModel;
import gov.iti.jets.model.dto.rental.RentalModel;
import gov.iti.jets.model.entity.rental.RentalEntity;
import gov.iti.jets.model.mapping.mapper.RentalMapper;
import gov.iti.jets.repository.RentalRepository;

import java.util.List;

public class RentalServiceImpl extends CrudServiceImpl<RentalEntity, RentalModel, RentalRequestModel, Integer> {

    public static final RentalRepository repository = new RentalRepository(RentalEntity.class);
    public static final RentalMapper mapper = RentalMapper.INSTANCE;

    public RentalServiceImpl() {
        super(repository, mapper);
    }

    public List<RentalModel> getRentalsByCustomerId(Integer customerId) {
        return
                mapper.mapToDtoList(repository.getRentalsByCustomerId(customerId));
    }
}
