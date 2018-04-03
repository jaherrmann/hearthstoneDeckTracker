package com.hearthstone.persistence;


import com.hearthstone.entity.Decklist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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

}
