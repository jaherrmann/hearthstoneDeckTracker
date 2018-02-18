package persistence;

import entity.Stats;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StatsDao {
    //private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get card by id
     */
    public Stats getById(int id){
        Session session = sessionFactory.openSession();
        Stats stats = session.get(Stats.class, id);
        session.close();
        return stats;
    }

    /**
     * update stats
     * @param stats Stats to be inserted or updated
     */
    public int insert(Stats stats){
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(stats);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete from the stats
     * @param stats the card to be deleted
     */
    public void delete(Stats stats){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(stats);
        transaction.commit();
        session.close();
    }
}
