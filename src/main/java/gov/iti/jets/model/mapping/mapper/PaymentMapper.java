//package gov.iti.jets.model.mapping.mapper;
//
//
//import gov.iti.jets.model.dto.core.PaymentModel;
//import gov.iti.jets.model.entity.rental.PaymentEntity;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
//
//import java.time.LocalDateTime;
//
//@Mapper( imports = {LocalDateTime.class})
//public interface PaymentMapper extends GenericMapper<PaymentEntity, PaymentModel> {
//    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);
//
////    @Mapping(target = "paymentId", ignore = true)
////    @Mapping(target = "lastUpdate", expression = "java(LocalDateTime.now())")
////    @Mapping(target = "customerByCustomerId", ignore = true)
////    @Mapping(target = "staffByStaffId", ignore = true)
////    @Mapping(target = "rentalByRentalId", ignore = true)
////    PaymentEntity mapToEntity(PaymentRequestModel dto);
//}
