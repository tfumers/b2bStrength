package com.toGames.b2bStrength.models.users;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Nationality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy="nationality", fetch= FetchType.EAGER)
    private Set<GenericUser> user;

    private String nationality;

    public Nationality() {
    }

    public Nationality(String nationality) {
        this.nationality = nationality;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Set<GenericUser> getUser() {
        return user;
    }

    public void setUser(Set<GenericUser> user) {
        this.user = user;
    }
}
