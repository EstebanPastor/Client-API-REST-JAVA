package clientapi.API.controller;
import clientapi.API.model.dto.ClientDto;
import clientapi.API.model.entity.Client;
import clientapi.API.model.payload.ResponseMessage;
import clientapi.API.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @PostMapping("client")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody ClientDto clientDto) {
        Client clientSave = null;
        try {
            clientSave = clientService.save(clientDto);


            return new ResponseEntity<>(ResponseMessage.builder().message("Successfully saved").object(ClientDto.builder().idClient(clientSave.getIdClient())
                    .name(clientSave.getName())
                    .surname(clientSave.getSurname())
                    .registerDate(clientSave.getRegisterDate())
                    .email(clientSave.getEmail())
                    .build()).build(), HttpStatus.CREATED);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(ResponseMessage.builder().message(exDt.getMessage()).object(null).build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("client/{id}")
    public ResponseEntity<?> update(@RequestBody ClientDto clientDto, @PathVariable Integer id) {

        Client clientUpdate = null;
        try {
            if(clientService.existsById(id)){
                clientDto.setIdClient(id);
                clientUpdate = clientService.save(clientDto);
                return new ResponseEntity<>(ResponseMessage.builder().message("Successfully saved").object(ClientDto.builder().idClient(clientUpdate.getIdClient())
                                .name(clientUpdate.getName())
                                .surname(clientUpdate.getSurname())
                                .registerDate(clientUpdate.getRegisterDate())
                                .email(clientUpdate.getEmail())
                                .build())
                        .build(), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(ResponseMessage.builder().message("The register doesnt exist").object(null).build(), HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(ResponseMessage.builder().message(exDt.getMessage()).object(null).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("client/{id}")

    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
           Client  clientDelete = clientService.findById(id);
            clientService.delete(clientDelete);
            return new ResponseEntity<>(clientDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt){
            return new ResponseEntity<>(ResponseMessage.builder().message(exDt.getMessage()).object(null).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("client/{id}")

    public ResponseEntity<?> showById(@PathVariable Integer id) {

        Client client = clientService.findById(id);

        if( client == null) {
            return new ResponseEntity<>(ResponseMessage.builder().message("The register does not exist ").object(null).build(), HttpStatus.NOT_FOUND);
        }

       return new ResponseEntity<>(ResponseMessage.builder().message("Client:").object(ClientDto.builder().idClient(client.getIdClient())
                        .name(client.getName())
                        .surname(client.getSurname())
                        .registerDate(client.getRegisterDate())
                        .email(client.getEmail())
                        .build())
                .build(), HttpStatus.OK);
    }

}
