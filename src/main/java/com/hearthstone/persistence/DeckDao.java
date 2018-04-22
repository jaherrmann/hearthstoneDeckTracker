//package com.hearthstone.persistence;
//
//import com.hearthstone.entity.Deck;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import java.util.List;
//
//public class DeckDao {
//    //private final Logger logger = LogManager.getLogger(this.getClass());
//    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
//
//    /**
//     * Get card by id
//     */
//    public Deck getById(int id){
//        Session session = sessionFactory.openSession();
//        Deck deck = session.get(Deck.class, id);
//        session.close();
//        return deck;
//    }
//
//    public List<Deck> getAllCards(){
//        Session session = sessionFactory.openSession();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Deck> query = builder.createQuery(Deck.class);
//        Root<Deck> root = query.from(Deck.class);
//        List<Deck> cards = session.createQuery(query).getResultList();
//        session.close();
//        return cards;
//    }
//
//    /**
//     * update deck
//     * @param deck Deck to be inserted or updated
//     */
//    public int insert(Deck deck){
//        int id = 0;
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        id = (int)session.save(deck);
//        transaction.commit();
//        session.close();
//        return id;
//    }
//
//    /**
//     * Delete from the deck
//     * @param deck the card to be deleted
//     */
//    public void delete(Deck deck){
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.delete(deck);
//        transaction.commit();
//        session.close();
//    }
//}
