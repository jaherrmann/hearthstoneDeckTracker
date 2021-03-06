package com.hearthstone.persistence;

import com.hearthstone.entity.Decklist;
import com.hearthstone.entity.Stats;
import com.hearthstone.entity.User;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.*;

class GenericDaoTest {
    GenericDao genericDao;
    private Logger logger = Logger.getLogger(this.getClass());
    private static Validator validator;

    @BeforeEach
    void setUp(){
        test.util.Database database = test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    void shouldAddAndReadValues() {
        GenericDao statsDao = new GenericDao(Stats.class);
        Stats stats = new Stats(5, 2, 45, 1);

        GenericDao userDao = new GenericDao(User.class);
        User user = new User("Fred", "Flintstone");

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

        String newName = "Gi";

        User user = (User)genericDao.getByID(1);
        user.setUser_name(newName);
        genericDao.update(user);

        User newUser = (User)genericDao.getByID(1);
        assertEquals("Gi", newUser.getUser_name());
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

    @Test
    void userCanAddMultipleDecks() {
        GenericDao userDao = new GenericDao(User.class);
        User user = new User("Fred", "Flintstone");

        userDao.add(user);
        GenericDao deckDao = new GenericDao(Decklist.class);
        Decklist decklist = new Decklist("Mind-flayer", user, "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Fire fly", "Praying Mantis", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Fire fly", "Fire fly", "Glacial Shard", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Fire fly", "Fire fly");

        Decklist decklist1 = new Decklist("Rush", user, "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Sleeper", "Praying Mantis", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Attack", "Fire fly", "Glacial Shard", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Cleric", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Fire fly", "Fire fly");

        deckDao.add(decklist);
        deckDao.add(decklist1);

        Decklist retrievedDecklist = (Decklist) deckDao.getByID(3);

        assertEquals(2, retrievedDecklist.getUser().getId());
    }


    @Test
    void userCanDeleteDeck(){
        GenericDao userDao = new GenericDao(User.class);
        GenericDao deckListDao = new GenericDao(Decklist.class);
        User user = new User("Fred", "Flintstone");

        userDao.add(user);
        GenericDao deckDao = new GenericDao(Decklist.class);
        Decklist decklist = new Decklist("Mind-flayer", user, "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Fire fly", "Praying Mantis", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Fire fly", "Fire fly", "Glacial Shard", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Fire fly", "Fire fly");

        Decklist decklist1 = new Decklist("Rush", user, "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Sleeper", "Praying Mantis", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Attack", "Fire fly", "Glacial Shard", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Cleric", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Fire fly", "Fire fly");

        deckDao.add(decklist);
        deckDao.add(decklist1);

        Decklist deck = (Decklist)deckListDao.getByID(3);

        deckDao.delete(deck);
        assertNull(deckDao.getByID(3));
    }

    @Test
    void shouldDeleteDeckAndNotUser(){
        GenericDao userDao = new GenericDao(User.class);
        GenericDao deckDao = new GenericDao(Decklist.class);

        Decklist deck = (Decklist) deckDao.getByID(1);
        deckDao.delete(deck);

        User user = (User) userDao.getByID(1);

        assertEquals(1, user.getId());
    }

    @Test
    void shouldAddNewUser(){
        GenericDao userDao = new GenericDao(User.class);
        User user = new User("Giannis", "An");
        userDao.add(user);
        User retrievedUser = (User)userDao.getByID(2);
        assertEquals("An", retrievedUser.getUser_password());
    }
}