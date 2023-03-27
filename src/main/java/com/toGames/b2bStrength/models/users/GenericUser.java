package com.toGames.b2bStrength.models.users;

import com.toGames.b2bStrength.models.clients.ClientStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class GenericUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserLoginInfo loginInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nationality_id")
    private Nationality nationality;

    private String username;

    private String firstname;

    private String lastname;

    private int phone;

    private char sex;

    private String icon;

    public GenericUser(String username, String firstname, String lastname, int phone, char sex, String icon) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.sex = sex;
        this.icon = icon;
    }
}
