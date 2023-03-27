package com.toGames.b2bStrength.models.users;

import com.toGames.b2bStrength.models.clients.Client;
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
public class UserLoginInfo {

//    relacionarlo con el user_id generico
    @Id
    @Column(name = "user_id")
    private long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private GenericUser user;

    private long typeId;

    private String email;

    private String hash;

    private String salt;

    private String passTest;

    private LocalDateTime lastLogin;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    public UserLoginInfo(long typeId, String email, String hash, String salt, String passTest, LocalDateTime lastLogin, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.typeId = typeId;
        this.email = email;
        this.hash = hash;
        this.salt = salt;
        this.passTest = passTest;
        this.lastLogin = lastLogin;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
