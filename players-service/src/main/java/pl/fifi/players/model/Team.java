package pl.fifi.players.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "teams")
public class Team implements Serializable {

    @Id
    @Column(updatable = false, nullable = false, name = "team_id")
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false)
    private Long ownerId;

    private String name;
    @ManyToMany(mappedBy = "teams")
    private Set<Player> players;
}
