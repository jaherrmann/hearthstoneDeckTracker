package persistence;

import entity.Deck;
import entity.Stats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.util.Database;

import static org.junit.jupiter.api.Assertions.*;

class DeckDaoTest {

    DeckDao dao;

    /**
     * 1) execute sql which deletes everything from table and inserts records
     */

    @BeforeEach
    void setUp(){
        test.util.Database database = test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new DeckDao();
    }


    /**
     * Verify that the second record is northsire cleric
     */
    @Test
    void getByIdSuccess() {
        Deck retrievedCard = dao.getById(2);
        assertEquals("Northshire Cleric", retrievedCard.getName());
    }

    /**
     * Verify that a new card was added properly
     */
    @Test
    void insertSuccess(){
        Deck newCard = new Deck("Auchenai Soulpriest", "Rare", 4, "Basic");
        int id = dao.insert(newCard);
        assertNotEquals(0,id);
        Deck insertedCard = dao.getById(id);
        assertEquals("Rare", insertedCard.getRarity());
    }


    /**
     *  Verify that the stats were inserted properly
     */
    @Test
    void insertWithStatsSuccess(){

        Deck newCard = new Deck("Auchenai Soulpriest", "Rare", 4, "Basic");

        String statDescription = "Stat1";

        Stats stat = new Stats(statDescription, newCard);

        newCard.addStat(stat);

        int id = dao.insert(newCard);


        assertNotEquals(0,id);
        Deck insertedCard = dao.getById(id);
        assertEquals("Rare", insertedCard.getRarity());
        //assertEquals(1, insertedCard.);
    }

    /**
     * Verify that a certain card is deleted from the deck
     */
    @Test
    void deleteSuccess(){
        dao.delete(dao.getById(4));
        assertNull(dao.getById(4));
    }
}