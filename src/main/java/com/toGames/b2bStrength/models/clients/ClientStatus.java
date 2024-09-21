package com.toGames.b2bStrength.models.clients;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClientStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String Status;

    @OneToMany(mappedBy="status", fetch= FetchType.EAGER)
    private Set<Client> clients;

    public ClientStatus(String status) {
        Status = status;
    }

    public void addClient(Client client){
        client.setStatus(this);
        clients.add(client);
    }
}
