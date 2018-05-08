package com.hearthstone.controller;

import com.hearthstone.entity.Decklist;
import com.hearthstone.entity.Stats;
import com.hearthstone.persistence.GenericDao;
import com.hearthstone.persistence.StatsDao;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CalculateStatsTest {

    GenericDao genericDao;
    Logger logger =  Logger.getLogger(this.getClass());

    @BeforeEach
    void setUp(){
        test.util.Database database = test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void shouldCalculateStatsProperly(){
        StatsDao statsDao = new StatsDao();

        GenericDao dao = new GenericDao(Stats.class);
        Stats stats = (Stats) dao.getByID(1);

        statsDao.addWin(stats, 3);
        statsDao.addLoss(stats, 3);
        statsDao.caluculateWinPercentage(stats);

        Stats retrievedStats = (Stats) dao.getByID(1);

        assertEquals(.5, retrievedStats.getWinPercentage());

    }


}