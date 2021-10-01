package com.machxgo.machxgo.client;

import com.machxgo.machxgo.user.User;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    
    private Long id;

    @OneToOne(optional = false)
    private User user;

    public Client() {
    }

    public Client(User user) {
        this.user = user;
    }

    public Client(Long id, User user) {
        this.id = id;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
