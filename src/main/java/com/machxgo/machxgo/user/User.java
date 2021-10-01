package com.machxgo.machxgo.user;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String password;
    private String doc;
    private String doc_type;

    public User() {}

    public User(String name, String email, String password, String doc, String doc_type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.doc = doc;
        this.doc_type = doc_type;
    }

    public User(Long id, String name, String email, String password, String doc, String doc_type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.doc = doc;
        this.doc_type = doc_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getDoc_type() {
        return doc_type;
    }

    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", doc='" + doc + '\'' +
                ", doc_type='" + doc_type + '\'' +
                '}';
    }

}
