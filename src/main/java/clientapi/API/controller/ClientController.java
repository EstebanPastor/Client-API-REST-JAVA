package clientapi.API.controller;
import clientapi.API.model.entity.Client;
import clientapi.API.service.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private IClient clientService;

    @PostMapping("client")
    public Client create(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("client")
    public Client update(@RequestBody Client client) {
        return clientService.save(client);
    }

    @DeleteMapping("client/{id}")
    public void delete(@PathVariable Integer id) {
        Client clientDelete = clientService.findById(id);
        clientService.delete(clientDelete);
    }

    @GetMapping("client/{id}")
    public Client showById(@PathVariable Integer id) {
        return clientService.findById(id);

    }

}
