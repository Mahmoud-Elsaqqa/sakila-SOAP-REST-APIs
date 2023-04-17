package gov.iti.jets.repository;

import gov.iti.jets.model.dto.extra.CustomerDetailsModel;
import gov.iti.jets.model.entity.customer.CustomerEntity;
import gov.iti.jets.model.entity.inventory.FilmEntity;
import gov.iti.jets.model.entity.rental.RentalEntity;
import gov.iti.jets.util.EntityManagerHelper;

import java.util.List;

public class CustomerRepository extends CrudRepositoryImpl<CustomerEntity, Integer> {

    public CustomerRepository(Class<CustomerEntity> entityClass) {
        super(entityClass);
    }

    public CustomerDetailsModel getCustomerFullDetails(Integer customerId) {
        return
                EntityManagerHelper.getEntityManager()
                        .createQuery("SELECT NEW gov.iti.jets.model.dto.extra.CustomerDetailsModel" +
                                        "(c.id, c.fullName, c.email, c.addressByAddressId.address, c.addressByAddressId.postalCode," +
                                        " c.addressByAddressId.phone, c.addressByAddressId.cityByCityId.city," +
                                        " c.addressByAddressId.cityByCityId.countryByCountryId.country," +
                                        " c.storeId, c.storeByStoreId.addressByAddressId.address) FROM customer c WHERE c.id = :id",
                                CustomerDetailsModel.class)
                        .setParameter("id", customerId)
                        .getSingleResult();
    }

    public List<FilmEntity> getRentedFilmsByCustomerId(Integer customerId) {
        return
                EntityManagerHelper.getEntityManager()
                        .createQuery("SELECT r.inventoryByInventoryId.filmByFilmId" +
                                " FROM rental r" +
                                " WHERE r.customerId = :id", FilmEntity.class)
                        .setParameter("id", customerId)
                        .getResultList();
    }


//    List<CustomerDetailsModel> findAllCustomerDetailsList();
//
//    Optional<CustomerDetailsModel> findCustomerDetailsById(Integer  erId);
//
//    List<PaymentModel> findAllCustomerPaymentListById(Integer  erId);
//
//    List<PaymentModel> findAllCustomerPaymentListByIdWithFilter(Integer  erId, LocalDate startDate, LocalDate endDate);
//
//    List<RentalModel> findAllCustomerRentalListById(Integer  erId);
//
//    List<RentalModel> findAllCustomerRentalListByIdWithFilter(Integer  erId, String status, LocalDate startDate, LocalDate endDate);
}
