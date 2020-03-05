package pl.fifi.players.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "players")
public class Player implements Serializable {

    @Id
    @Column(updatable = false, nullable = false, name = "player_id")
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false)
    private Long ownerId;

    private String name;
    private String pinNumber;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "player_team", joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
    private Set<Team> teams;

}
