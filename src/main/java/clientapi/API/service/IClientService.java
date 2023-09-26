package clientapi.API.service;

import clientapi.API.model.dto.ClientDto;
import clientapi.API.model.entity.Client;

public interface IClientService {
    Client save(ClientDto client);
    Client findById(Integer id);
    void delete(Client client);

    boolean existsById(Integer id);

}
