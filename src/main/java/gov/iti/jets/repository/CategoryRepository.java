package gov.iti.jets.repository;

import gov.iti.jets.model.entity.inventory.CategoryEntity;

public class CategoryRepository extends CrudRepositoryImpl {

    public CategoryRepository() {
        super(CategoryEntity.class);
    }
}
