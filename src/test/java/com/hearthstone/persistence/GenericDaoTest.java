package com.hearthstone.persistence;

import com.hearthstone.entity.Decklist;
import com.hearthstone.entity.Stats;
import com.hearthstone.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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


//    @Test
//    void getByID() {
//    }
//
//    @Test
//    void delete() {
//    }
//
//    @Test
//    void getAll() {
//    }

    @Test
    void add() {
        GenericDao userDao = new GenericDao(User.class);
        User user = new User("Larry", "Sanders");
        userDao.add(user);

        User retrievedUser = (User)userDao.getByID(2);

        assertEquals("Sanders", retrievedUser.getUser_password());
    }

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