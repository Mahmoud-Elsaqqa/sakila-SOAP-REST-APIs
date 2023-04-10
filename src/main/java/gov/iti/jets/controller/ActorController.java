package gov.iti.jets.controller;

import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.service.ActorService;
import gov.iti.jets.service.ActorServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;


@Path("/actors")
public class ActorController implements CrudController<ActorModel> {

    ActorServiceImpl actorService = new ActorServiceImpl();

    public List<ActorModel> findAll() {
        return actorService.findAll();
    }

    public void deleteById(Integer id) {
        actorService.deleteById(id);
    }

    public void delete(ActorModel dto) {
        actorService.delete(dto);
    }

    public boolean existsById(Integer id) {
        return actorService.existsById(id);
    }

    public long count() {
        return actorService.count();
    }

    public ActorModel findById(Integer id) {
        return actorService.findById(id);
    }

    public void save(ActorModel dto) {
        actorService.save(dto);
    }

    public void update(ActorModel dto) {
        actorService.update(dto);
    }

    public void updateById(Integer id) {
        actorService.updateById(id);
    }
}
