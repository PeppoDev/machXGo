package com.machxgo.machxgo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public Optional<Client> getClient(Long id){
        boolean exists = clientRepository.existsById(id);

        if(!exists){
            throw new IllegalStateException("User doesnt registered");
        }
        else{
            return clientRepository.findById(id);
        }
    }


    public void registerNewClient(Client client){
            clientRepository.save(client);
    }

    public void deleteClient(Long id){
        boolean exists = clientRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Client doesnt registered");
        }else{
            clientRepository.deleteById(id);
        }
    }

}
