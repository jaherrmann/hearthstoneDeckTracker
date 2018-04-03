package com.hearthstone.persistence;

import com.hearthstone.entity.Deck;
import com.hearthstone.entity.Decklist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * A class used to test decklist
 */
class DecklistDaoTest {

    DecklistDao dao = new DecklistDao();

//    @BeforeEach
//    void setUp(){
//        test.util.Database database = test.util.Database.getInstance();
//        database.runSQL("cleandb.sql");
//        dao = new DecklistDao();
//    }

    /**
     * Verify that the 5th card is Glacial Shard
     */
    @Test
    void getBy5thCardSuccess(){
        Decklist retrievedCard = dao.getCardByNumber("card5");
        assertEquals("Glacial Shard", retrievedCard.getCard5());
    }
}