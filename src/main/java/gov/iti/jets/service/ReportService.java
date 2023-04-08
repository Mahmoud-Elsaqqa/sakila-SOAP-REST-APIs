package gov.iti.jets.service;


import gov.iti.jets.model.dto.extra.CategorySalesModel;
import gov.iti.jets.model.dto.extra.StoreSalesModel;

import java.util.List;

public interface ReportService {

    List<CategorySalesModel> reportSalesByCategory();

    List<StoreSalesModel> reportSalesByStore();
}
