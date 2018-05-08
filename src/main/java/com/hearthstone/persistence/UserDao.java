package com.hearthstone.persistence;

import org.apache.log4j.Logger;
import com.hearthstone.entity.User;
import com.hearthstone.entity.Decklist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Class made to manipulate the user table
 * @author jeff
 */
public class UserDao {
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    Logger logger = Logger.getLogger(this.getClass());

    /**
     *
     * @param userId userid
     * @return the deck sorted by userId
     */
    public User getUserFromId(int userId){
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, userId);
        session.close();
        return user;
    }

    /**
     * This will get the deck by userId
     * @param user userId
     * @return decklist the collection of decks a user has
     */
    public List<Decklist> getDeckByUserId(User user) {
        Session session = sessionFactory.openSession();
        int userId = user.getId();
        logger.debug("Searching for user with userId" + " = " + user);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Decklist> query = builder.createQuery( Decklist.class );
        Root<Decklist> root = query.from( Decklist.class );
        query.select(root).where(builder.equal(root.get("user"), userId));
        List<Decklist> decks = session.createQuery( query ).getResultList();

        session.close();
        return decks;
    }

    /**
     * Retrieve a user by username and password
     * @param username username
     * @param password password
     * @return entities the retireved object
     */
    public List<User> getUserbyUsernamePassword(String username, String password) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with " + username + " = " + password);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery( User.class );
        Root<User> root = query.from( User.class );

        query.select(root).where(builder.and(builder.equal(root.get("user_name"), username), builder.equal(root.get("user_password"), password)));
        List<User> entities = session.createQuery( query ).getResultList();

        session.close();
        return entities;
    }
}
