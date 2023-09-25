package clientapi.API.model.dao;

import clientapi.API.model.entity.Client;
import org.springframework.data.repository.CrudRepository;


public interface ClientDAO extends CrudRepository<Client, Integer> {



}
