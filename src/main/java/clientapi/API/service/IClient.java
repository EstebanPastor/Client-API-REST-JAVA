package clientapi.API.service;

import clientapi.API.model.entity.Client;

public interface IClient {
    Client save(Client client);
    Client findById(Integer id);
    void delete(Client client);

}
