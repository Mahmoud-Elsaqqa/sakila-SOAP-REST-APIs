package gov.iti.jets.controller;

import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.service.ActorServiceImpl;
import jakarta.ws.rs.Path;


@Path("/actors")
public class ActorController extends CrudControllerImpl<ActorModel> {
    public ActorController() {
        super(new ActorServiceImpl());
    }
}
