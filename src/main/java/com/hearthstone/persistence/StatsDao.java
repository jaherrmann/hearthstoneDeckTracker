package com.hearthstone.persistence;

import com.hearthstone.entity.Decklist;
import com.hearthstone.entity.Stats;
import com.hearthstone.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StatsDao {
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    Logger logger = Logger.getLogger(this.getClass());

    /**
     *
     * @param statsId
     * @return the deck sorted by userId
     */
    public Stats getStatsFromId(int statsId){
        Session session = sessionFactory.openSession();
        Stats stats = session.get(Stats.class, statsId);
        session.close();
        return stats;
    }

    public List<Stats> getStatsByDeckId(Decklist decklist) {
        Session session = sessionFactory.openSession();
        int deckId = decklist.getId();
        logger.debug("Searching for stats with deckId" + " = " + deckId);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Stats> query = builder.createQuery( Stats.class );
        Root<Stats> root = query.from( Stats.class );
        query.select(root).where(builder.equal(root.get("deck_id"), deckId));
        List<Stats> stats = session.createQuery( query ).getResultList();

        session.close();
        return stats;
    }

    public int addWin(Stats stats, int winNumbers){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        int wins = stats.getWins() + winNumbers;
        logger.info(wins);

        stats.setWins((wins));

        session.update(stats);
        transaction.commit();
        session.close();
        return(wins);
    }

    public int addLoss(Stats stats, int lossNumbers){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        int losses = stats.getLosses() + lossNumbers;
        logger.info(losses);

        stats.setLosses((losses));

        session.update(stats);
        transaction.commit();
        session.close();
        return(losses);
    }

    public List<Stats> getStatsFromDeckId(int deckId){
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Stats> query = builder.createQuery( Stats.class );
        Root<Stats> root = query.from( Stats.class );
        query.select(root).where(builder.equal(root.get("deck_id"), deckId));
        List<Stats> stats = session.createQuery( query ).getResultList();

        session.close();
        return stats;
    }

    public double caluculateWinPercentage(Stats stats){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        double wins = stats.getWins();
        logger.info(wins);
        double losses = stats.getLosses();
        logger.info(losses);
        double totalGames = wins + losses;
        logger.info(totalGames);
        double winPercentage = (wins / totalGames);
        logger.info(winPercentage);


        stats.setWinPercentage(winPercentage);

        session.update(stats);
        transaction.commit();
        session.close();
        return(winPercentage);
    }
}