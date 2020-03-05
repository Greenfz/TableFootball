package pl.fifi.players;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import pl.fifi.players.model.Team;
import pl.fifi.players.repository.dao.PlayerDao;
import pl.fifi.players.model.Player;
import pl.fifi.players.repository.dao.TeamDao;

import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class PlayersServiceApplication {



    public static void main(String[] args) {
        SpringApplication.run(PlayersServiceApplication.class, args);

        PlayerDao playerDao = new PlayerDao();
        TeamDao teamDao = new TeamDao();

        Player player = new Player();
        player.setOwnerId(1L);
        player.setName("Fifi");
        player.setPinNumber("1234");

        Team team = new Team();
        team.setName("AAAA");
        team.setOwnerId(1L);
        team.setPlayers(new HashSet<>());
        player.setTeams(new HashSet<>());

        team.getPlayers().add(player);
        player.getTeams().add(team);
//        teamDao.save(team);
//        playerDao.save(player);

        Player aaa = playerDao.findOne("2ca46e82-37d5-4be7-acff-b42d43d2a5fc");
        System.out.println(aaa.getName());
//        List<Player> players = playerDao.findAll("72d72106-db9f-4a47-93e6-b2efed15615a");
//
//        for (Player p: players) {
//            System.out.println(p.getName());
//        }

    }

}
