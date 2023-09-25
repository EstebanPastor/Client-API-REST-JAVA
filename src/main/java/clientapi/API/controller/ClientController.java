package clientapi.API.controller;
import clientapi.API.model.entity.Client;
import clientapi.API.service.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private IClient clientService;

    @PostMapping("client")
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("client")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client) {
        return clientService.save(client);
    }

    @DeleteMapping("client/{id}")

    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Client clientDelete = clientService.findById(id);
            clientService.delete(clientDelete);
            return new ResponseEntity<>(clientDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt){

            response.put("message", exDt.getMessage());
            response.put("client", null);

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("client/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client showById(@PathVariable Integer id) {
        return clientService.findById(id);

    }

}
