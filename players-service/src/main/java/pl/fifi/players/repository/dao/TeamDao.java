package pl.fifi.players.repository.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.fifi.players.exception.teamExceptions.TeamDuplicationException;
import pl.fifi.players.model.Team;
import pl.fifi.players.repository.TeamRepository;

@Repository
public class TeamDao extends DaoBase<Team> implements TeamRepository {

    @Override
    public Team findByName(String name) {
        if(findOne(name.toLowerCase()) != null) throw new TeamDuplicationException("Team with this name already exist")
    }


}
