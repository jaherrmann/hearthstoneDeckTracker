package persistence;

import entity.Deck;
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

    @Test
    void deleteSuccess(){
        dao.delete(dao.getById(10));
        assertNull(dao.getById(10));
    }
}