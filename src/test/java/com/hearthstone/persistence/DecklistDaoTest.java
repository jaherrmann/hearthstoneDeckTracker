package com.hearthstone.persistence;

import com.hearthstone.entity.Decklist;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import test.util.Database;


import static org.junit.jupiter.api.Assertions.*;


/**
 * A class used to test decklist
 */
class DecklistDaoTest {

    DecklistDao dao;

    @BeforeEach
    void setUp(){
        test.util.Database database = test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new DecklistDao();
    }

    /**
     * Verify that the 5th card is Glacial Shard
     */
    @Test
    void getBy5thCardSuccess(){
        Decklist retrievedCard = dao.getCardByNumber("card5");
        assertEquals("Glacial Shard", retrievedCard.getCard5());
    }
}