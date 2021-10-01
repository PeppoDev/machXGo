package com.machxgo.machxgo.client;

import com.machxgo.machxgo.user.User;
import com.machxgo.machxgo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public List<Client> getUsers(){
        return clientService.getClients();
    }

    @GetMapping(path = "{id}")
    public Optional<Client> getUser(@PathVariable("id") Long id){
        return clientService.getClient(id);
    }

    @PostMapping
    public void registerNewUser(@RequestBody Client client){
        clientService.registerNewClient(client);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") Long id){
        clientService.deleteClient(id);
    }

}
