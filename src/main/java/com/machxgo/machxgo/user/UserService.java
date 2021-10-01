package com.machxgo.machxgo.user;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id){
        boolean exists = userRepository.existsById(id);

        if(!exists){
            throw new IllegalStateException("User doesnt registered");
        }
        else{
            return userRepository.findById(id);
        }
    }

    public void registerNewUser(User user){
        Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());

        if(userByEmail.isPresent()){
            throw new IllegalStateException("User already registered");
        }else{
            userRepository.save(user);
        }
    }

    public void deleteUser(Long id){
        boolean exists = userRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("User doesnt registered");
        }else{
            userRepository.deleteById(id);
        }
    }


    @Transactional
    public void updateUser(Long id, String name, String email, String password){
        User user = userRepository.findById(id).orElseThrow(()-> new IllegalStateException(
                String.format("User with id %d doesnt exists", id.toString())));

        if(name != null && name.length()>0 && !Objects.equals(user.getName(), name)){
            user.setName(name);
        }


        Optional<User> optionalUser =  userRepository.findUserByEmail(email);

        if(optionalUser.isPresent()){
            throw new IllegalStateException("email already in use");
        }

        if(email != null && email.length()>0 && !Objects.equals(user.getEmail(), email)){
            user.setEmail(email);
        }

        if(password != null && password.length()>0 && !Objects.equals(user.getPassword(), password)){
            user.setEmail(email);
        }
    }
}
