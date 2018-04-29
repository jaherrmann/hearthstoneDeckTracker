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
 */
public class DecklistDao {
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get card by card number
     */
    public Decklist getCardByNumber(String cardName){
        Session session = sessionFactory.openSession();
        Decklist decklist = session.get(Decklist.class, cardName);
        session.close();
        return decklist;
    }

    /**
     * Get deck name from Id
     */
    public Decklist getNameFromId(int id){
        Session session = sessionFactory.openSession();
        Decklist decklist = session.get(Decklist.class, id);
        session.close();
        return decklist;
    }


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
