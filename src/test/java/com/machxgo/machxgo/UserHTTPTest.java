package com.machxgo.machxgo;

import com.machxgo.machxgo.user.User;
import com.machxgo.machxgo.user.UserController;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserHTTPTest {
    @Autowired
    private UserController userController;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() throws Exception {
        Assertions.assertThat(userController).isNotNull();
        Assertions.assertThat(port).isNotNull();
        Assertions.assertThat(restTemplate).isNotNull();
    }

    @Test
    public void showUsers() throws Exception{
        String url = String.format("http://localhost:%d/api/v1/user",port);
        Assertions.assertThat(this.restTemplate.getForObject(url, User[].class)).isNotEmpty();
    }

    @Test
    public void saveUser() throws Exception{
        User user =  new User("Ruan","ruan.victor@email.com","12345678", "000.000.000-00", "cpf");
        String url = String.format("http://localhost:%d/api/v1/user",port);
        Assertions.assertThat(restTemplate.postForObject(url, user, ResponseEntity.class)).isNull();
    }

    @Test
    public void editUserWithUsedEmail() throws Exception{
        User user =  new User("Ruan","ruan.victor1@email.com","12345678", "000.000.000-00", "cpf");
        String url = String.format("http://localhost:%d/api/v1/user",port);
        Assertions.assertThat(restTemplate.postForObject(url, user, ResponseEntity.class)).isNull();

        // edit test
        Map<String, String> params = new HashMap< String, String >();
        params.put("id", "1");
        String putUrl = String.format("http://localhost:%d/api/v1/user?email=ruan.victor1@email.com&name=Ruan", port);
        try {
            restTemplate.put(putUrl, user, params);
        }catch (Exception e){
            Assertions.assertThat(e.getMessage()).isEqualTo("User already registered");
        }
    }




}
