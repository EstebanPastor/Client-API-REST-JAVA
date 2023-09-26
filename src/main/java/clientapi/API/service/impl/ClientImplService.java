package clientapi.API.service.impl;

import clientapi.API.model.dao.ClientDAO;
import clientapi.API.model.dto.ClientDto;
import clientapi.API.model.entity.Client;
import clientapi.API.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ClientImplService implements IClientService {

    @Autowired
    private ClientDAO clientDao;

    @Override
    public List<Client> listAll() {
        return (List) clientDao.findAll();
    }

    @Transactional
    @Override
    public Client save(ClientDto clientDto) {
        Client client = Client.builder().idClient(clientDto.getIdClient())
                .name(clientDto.getName())
                .surname(clientDto.getSurname())
                .registerDate(clientDto.getRegisterDate())
                .email(clientDto.getEmail())
                .build();
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

    @Override
    public boolean existsById(Integer id) {
        return clientDao.existsById(id);
    }
}
