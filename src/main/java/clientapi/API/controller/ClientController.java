package clientapi.API.controller;
import clientapi.API.model.dto.ClientDto;
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
    public ClientDto create(@RequestBody ClientDto clientDto) {

        Client clientSave = clientService.save(clientDto);

        return ClientDto.builder().idClient(clientSave.getIdClient())
                .name(clientSave.getName())
                .surname(clientSave.getSurname())
                .registerDate(clientSave.getRegisterDate())
                .email(clientSave.getEmail())
                .build();

    }

    @PutMapping("client")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto update(@RequestBody ClientDto clientDto) {

        Client clientUpdate = clientService.save(clientDto);

        return ClientDto.builder().idClient(clientUpdate.getIdClient())
                .name(clientUpdate.getName())
                .surname(clientUpdate.getSurname())
                .registerDate(clientUpdate.getRegisterDate())
                .email(clientUpdate.getEmail())
                .build();

    }

    @DeleteMapping("client/{id}")

    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();

        try {
           Client  clientDelete = clientService.findById(id);
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
    public ClientDto showById(@PathVariable Integer id) {
        Client client = clientService.findById(id);
        return ClientDto.builder().idClient(client.getIdClient())
                .name(client.getName())
                .surname(client.getSurname())
                .registerDate(client.getRegisterDate())
                .email(client.getEmail())
                .build();

    }

}
