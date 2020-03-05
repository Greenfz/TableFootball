package pl.fifi.players.domain.teams;

import org.springframework.beans.factory.annotation.Autowired;
import pl.fifi.players.model.Player;
import pl.fifi.players.repository.TeamRepository;

public class TeamCreator {

    @Autowired
    TeamRepository teamRepo;

    public void createNewTeam(Player firstPlayer, Player secondPlayer, String name){

        teamRepo.f
    }

}
