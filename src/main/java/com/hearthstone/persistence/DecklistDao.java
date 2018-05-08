package com.hearthstone.persistence;

import com.hearthstone.entity.User;
import com.hearthstone.entity.Decklist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Class designed to insert into decklist
 * @author jeff
 */
public class DecklistDao {
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * This will get the cardName
     * @param cardName name
     * @return decklist the decklist object
     */
    public Decklist getCardByNumber(String cardName){
        Session session = sessionFactory.openSession();
        Decklist decklist = session.get(Decklist.class, cardName);
        session.close();
        return decklist;
    }

    /**
     * This will get the name from id
     * @param id id
     * @return decklist object
     */
    public Decklist getNameFromId(int id){
        Session session = sessionFactory.openSession();
        Decklist decklist = session.get(Decklist.class, id);
        session.close();
        return decklist;
    }

    /**
     * This will get a list of decks by Id
     * @param id the id
     * @return decklist a list of decklist objects
     */
    public List<Decklist> getDeckById(int id) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Decklist> query = builder.createQuery( Decklist.class );
        Root<Decklist> root = query.from( Decklist.class );
        query.select(root).where(builder.equal(root.get("id"), id));
        List<Decklist> decks = session.createQuery( query ).getResultList();

        session.close();
        return decks;
    }
}
