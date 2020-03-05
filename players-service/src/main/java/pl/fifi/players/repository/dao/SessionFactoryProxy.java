package pl.fifi.players.repository.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import pl.fifi.players.model.Player;
import pl.fifi.players.model.Team;

@Component
public class SessionFactoryProxy {

    private static SessionFactory sessionFactory;

    private static void build() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Player.class);
        configuration.addAnnotatedClass(Team.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null){
            build();
        }
        return sessionFactory;
    }
}
