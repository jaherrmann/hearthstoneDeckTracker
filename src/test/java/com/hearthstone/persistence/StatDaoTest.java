package com.hearthstone.persistence;

//import com.hearthstone.entity.Deck;
import com.hearthstone.entity.Stats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatDaoTest {

    StatDao dao;

    /**
     * 1) execute sql which deletes everything from table and inserts records
     */


    @BeforeEach
    void setUp(){
        test.util.Database database = test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new StatDao();
    }

    /**
     * Verify that the second record is northsire cleric
     */
//    @Test
//    void getByIdSuccess() {
//        Stats retrievedCard = dao.getById(2);
//        assertEquals("Big", retrievedCard.getDescription());
//    }

    /**
     * Verify that a new card was added properly
     */
//    @Test
//    void insertSuccess(){
//
//        DeckDao deckDao = new DeckDao();
//        Deck deck = deckDao.getById(1);
//
//
//        Stats newStat = new Stats("Control", deck);
//        deck.addStat(newStat);
//
//        int id = dao.insert(newStat);
//
//        assertNotEquals(0,id);
//        Stats insertedStat = dao.getById(id);
//        assertEquals("Control", insertedStat.getDescription());
//        assertNotNull(insertedStat.getDeck().getName());
//        assertEquals(5, insertedStat.getDeck().getMana_cost());
//    }
    /**
     * Verify that the stat table is updating
     */
//    @Test
//    void updateSuccess(){
//        String newDescription = "Puyo";
//        Stats statToUpdate = dao.getById(4);
//        statToUpdate.setDescription(newDescription);
//        dao.saveOrUpdate(statToUpdate);
//        Stats retrievedStat = dao.getById(4);
//        assertEquals(newDescription,retrievedStat.getDescription());
//    }

    /**
     * Verify that a certain card is deleted from the stat
     */
//    @Test
//    void deleteSuccess(){
//        dao.delete(dao.getById(1));
//        assertNull(dao.getById(1));
//    }
}