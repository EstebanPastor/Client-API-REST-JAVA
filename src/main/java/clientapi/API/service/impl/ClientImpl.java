package clientapi.API.service.impl;

import clientapi.API.model.dao.ClientDAO;
import clientapi.API.model.entity.Client;
import clientapi.API.service.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClientImpl implements IClient {

    @Autowired
    private ClientDAO clientDao;

    @Transactional
    @Override
    public Client save(Client client) {
        return clientDao.save(client);
    }
    @Transactional(readOnly = true)
    @Override
    public Client findById(Integer id) {
        return clientDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delete(Client client) {
        clientDao.delete(client);
    }
}