package clientapi.API.service;

import clientapi.API.model.dto.ClientDto;
import clientapi.API.model.entity.Client;

public interface IClient {
    Client save(ClientDto client);
    Client findById(Integer id);
    void delete(Client client);

}
