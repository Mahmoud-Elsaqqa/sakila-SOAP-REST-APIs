package gov.iti.jets.service;

import gov.iti.jets.model.dto.request.StoreRequestModel;
import gov.iti.jets.model.dto.rental.StoreModel;
import gov.iti.jets.model.entity.rental.StoreEntity;
import gov.iti.jets.model.mapping.mapper.StoreMapper;
import gov.iti.jets.repository.StoreRepository;

public class StoreServiceImpl extends CrudServiceImpl<StoreEntity, StoreModel, StoreRequestModel, Integer> {
    public static final StoreRepository repository = new StoreRepository(StoreEntity.class);
    public static final StoreMapper mapper = StoreMapper.INSTANCE;

    public StoreServiceImpl() {
        super(repository, mapper);
    }
}
