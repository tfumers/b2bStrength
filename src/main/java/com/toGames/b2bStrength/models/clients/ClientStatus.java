package com.toGames.b2bStrength.models.clients;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ClientStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String Status;

    @OneToMany(mappedBy="status", fetch= FetchType.EAGER)
    private Set<Client> clients;

    public ClientStatus() {
    }

    public ClientStatus(String status) {
        Status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
