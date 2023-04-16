package gov.iti.jets.model.mapping.mapper;


import gov.iti.jets.model.dto.PaymentRequestModel;
import gov.iti.jets.model.dto.rental.PaymentModel;
import gov.iti.jets.model.entity.rental.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "default", imports = {LocalDateTime.class})
public interface PaymentMapper extends BaseMapper<PaymentEntity, PaymentModel, PaymentRequestModel> {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lastUpdate", expression = "java(LocalDateTime.now())")
    @Mapping(target = "customerByCustomerId", ignore = true)
    @Mapping(target = "staffByStaffId", ignore = true)
    @Mapping(target = "rentalByRentalId", ignore = true)
    PaymentEntity mapToEntity(PaymentRequestModel dto);

    @Override
    @Mapping(target = "customerByCustomerId" ,ignore = true)
    @Mapping(target = "rentalByRentalId" ,ignore = true)
    @Mapping(target = "staffByStaffId" ,ignore = true)
    PaymentModel mapToDto(PaymentEntity entity);
}
