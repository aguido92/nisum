package com.nisum.challenge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private String name;

    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Phone> phones;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;


    private UUID token;

    private boolean isActive;
    public User() {
    }

    @PrePersist
    protected void onCreate() {
        created = new Date();
        modified = new Date();
        lastLogin = new Date();
        token = UUID.randomUUID();
        isActive = true;
    }

}
