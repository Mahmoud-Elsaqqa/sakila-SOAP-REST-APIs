package gov.iti.jets.repository;

import gov.iti.jets.model.entity.BaseEntity;
import gov.iti.jets.model.entity.inventory.ActorEntity;

public class ActorRepo extends CrudRepositoryImpl {
    public ActorRepo() {
        super(ActorEntity.class);
    }
}
