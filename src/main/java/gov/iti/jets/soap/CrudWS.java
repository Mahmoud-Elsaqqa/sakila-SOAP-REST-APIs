package gov.iti.jets.soap;

import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.dto.BaseRequestModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface CrudWS<M extends BaseModel, R extends BaseRequestModel> {

    @WebMethod
    List<M> findAll();

    @WebMethod
    void deleteById(@WebParam(name = "id") Integer id );

    @WebMethod
    boolean existsById(@WebParam(name = "id") Integer id);

    @WebMethod
    long count();

    @WebMethod
    M findById(@WebParam(name = "id") Integer id);

    @WebMethod
    void save(@WebParam(name = "requestDto") R requestDto);

    @WebMethod
    void update(@WebParam(name = "id") Integer id, @WebParam(name = "requestDto") R requestDto);
}
