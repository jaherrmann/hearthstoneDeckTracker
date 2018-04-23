package com.hearthstone.persistence;

import com.hearthstone.entity.Decklist;
import com.hearthstone.entity.Stats;
import com.hearthstone.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.net.www.content.text.Generic;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericDaoTest {
    GenericDao genericDao;
    DecklistDao decklistDao;

    @BeforeEach
    void setUp(){
        test.util.Database database = test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        //decklistDao = new DecklistDao();
    }


    @Test
    void shouldAddAndReadValues() {
        GenericDao statsDao = new GenericDao(Stats.class);
        Stats stats = new Stats(5, 2, 45, 1);

        GenericDao userDao = new GenericDao(User.class);
        User user = new User(2, "Fred", "Flintstone");

        userDao.add(user);
        GenericDao deckDao = new GenericDao(Decklist.class);
        Decklist decklist = new Decklist("Control",user, "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Fire fly","Praying Mantis","Fire fly","Fire fly","Fire fly","Fire fly","Fire fly","Fire fly",
                "Fire fly","Fire fly","Glacial Shard","Fire fly","Fire fly","Fire fly","Fire fly", "Fire fly",
                "Fire fly","Fire fly","Fire fly","Fire fly","Fire fly","Fire fly","Fire fly","Fire fly",
                "Fire fly", "Fire fly");

        statsDao.add(stats);
        deckDao.add(decklist);

        Stats retrievedStats = (Stats)statsDao.getByID(2);
        assertEquals(5, retrievedStats.getWins());

        User retrievedUser = (User)userDao.getByID(2);
        assertEquals("Flintstone", retrievedUser.getUser_password());

        Decklist retrievedDecklist = (Decklist)deckDao.getByID(2);
        assertEquals("Praying Mantis", retrievedDecklist.getCard6());
    }

    @Test
    void shouldUpdateUserNameInTables(){
        genericDao = new GenericDao(User.class);

        String newName = "Giannis";

        User user = (User)genericDao.getByID(1);
        user.setUser_name(newName);
        genericDao.update(user);

        User newUser = (User)genericDao.getByID(1);
        assertEquals("Giannis", newUser.getUser_name());
    }

    @Test
    void shouldGetAllDecks(){
        genericDao = new GenericDao(Decklist.class);
        Stats stats = new Stats(5, 2, 45, 1);

        List<Decklist> decklist = genericDao.getAll();
        assertEquals(1, decklist.size());
    }

    @Test
    void shouldDeleteFromTable() {
        genericDao = new GenericDao(Stats.class);
        Stats stats = (Stats)genericDao.getByID(1);
        genericDao.delete(stats);
        assertNull(genericDao.getByID(1));
    }
//
//    @Test
//    void getAll() {
//    }

//    @Test
//    void update() {
//    }
//
//    @Test
//    void getByPropertyEqual() {
//    }
//
//    @Test
//    void getByPropertyString() {
//    }
//
//    @Test
//    void getByPropertyLike() {
//    }

}