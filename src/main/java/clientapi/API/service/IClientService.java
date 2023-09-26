package clientapi.API.service;

import clientapi.API.model.dto.ClientDto;
import clientapi.API.model.entity.Client;

import java.util.List;

public interface IClientService {

    List<Client> listAll();
    Client save(ClientDto client);
    Client findById(Integer id);
    void delete(Client client);

    boolean existsById(Integer id);

}
