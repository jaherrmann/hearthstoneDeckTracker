package com.hearthstone.persistence;


import com.hearthstone.entity.Decklist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Class designed to insert into decklist
 */
public class DecklistDao {
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get card by card number
     */
    public Decklist getCardByNumber(String cardNumber){
        Session session = sessionFactory.openSession();
        Decklist decklist = session.get(Decklist.class, cardNumber);
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
}
