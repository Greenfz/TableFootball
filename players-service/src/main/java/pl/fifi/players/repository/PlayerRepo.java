package pl.fifi.players.repository;

import pl.fifi.players.model.Player;

public interface PlayerRepo {

    Player findOne(String id);

}
