package com.hearthstone.persistence;

import com.hearthstone.entity.Decklist;
import com.hearthstone.entity.Stats;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StatsDaoTest {

    StatsDao dao;
    GenericDao genericDao;
    Logger logger =  Logger.getLogger(this.getClass());


    @BeforeEach
    void setUp(){
        test.util.Database database = test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new StatsDao();
    }


    @Test
    void shouldGetStatsById(){
        StatsDao stats = new StatsDao();
        Stats retrievedStats = stats.getStatsFromId(1);
        assertEquals(retrievedStats.getLosses(), 2);
    }

    @Test
    void shouldReturnStatsByDeckId(){
        StatsDao statsDao = new StatsDao();
        GenericDao deckDao = new GenericDao(Decklist.class);
        Decklist decklist = (Decklist) deckDao.getByID(1);


        List<Stats> retrievedStats = statsDao.getStatsByDeckId(decklist);
        logger.info(retrievedStats);

        assertEquals(65, retrievedStats.get(0).getWinPercentage());
    }

    @Test
    void shouldAddAWin(){
        StatsDao statsDao = new StatsDao();
        GenericDao dao = new GenericDao(Stats.class);
        Stats stats = (Stats) dao.getByID(1);

        statsDao.addWin(stats);

        Stats retrievedStats = (Stats) dao.getByID(1);

        assertEquals(2, retrievedStats.getWins());
    }

    @Test
    void shouldAddALoss(){
        StatsDao statsDao = new StatsDao();
        GenericDao dao = new GenericDao(Stats.class);
        Stats stats = (Stats) dao.getByID(1);

        statsDao.addLoss(stats);

        Stats retrievedStats = (Stats) dao.getByID(1);

        assertEquals(3, retrievedStats.getLosses());
    }
}