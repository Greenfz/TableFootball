package pl.fifi.players.repository;

import pl.fifi.players.model.Team;

public interface TeamRepository {

    Team findByName(String name);
}
