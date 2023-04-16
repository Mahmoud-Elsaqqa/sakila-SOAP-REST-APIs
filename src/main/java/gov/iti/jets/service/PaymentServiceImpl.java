package gov.iti.jets.service;

import gov.iti.jets.model.dto.PaymentRequestModel;
import gov.iti.jets.model.dto.rental.PaymentModel;
import gov.iti.jets.model.entity.rental.PaymentEntity;
import gov.iti.jets.model.mapping.mapper.BaseMapper;
import gov.iti.jets.model.mapping.mapper.PaymentMapper;
import gov.iti.jets.repository.CrudRepository;
import gov.iti.jets.repository.PaymentRepository;

public class PaymentServiceImpl extends CrudServiceImpl<PaymentEntity, PaymentModel, PaymentRequestModel, Integer> {

    public static final PaymentRepository repository = new PaymentRepository(PaymentEntity.class);
    public static final PaymentMapper mapper = PaymentMapper.INSTANCE;

    public PaymentServiceImpl() {
        super(repository, mapper);
    }
}
