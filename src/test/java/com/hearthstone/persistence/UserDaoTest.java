package com.hearthstone.persistence;

import com.hearthstone.entity.Decklist;
import com.hearthstone.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    GenericDao genericDao;

    @BeforeEach
    void setUp(){
        test.util.Database database = test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void shouldGetUserById(){
        UserDao user = new UserDao();
        User retrievedUser = user.getUserFromId(1);
        assertEquals(retrievedUser.getUser_name(), "Action");
    }


    @Test
    void shouldReturnListofDecksByUserId(){
        UserDao user = new UserDao();
        User retrievedUser = user.getUserFromId(1);

        GenericDao deckDao = new GenericDao(Decklist.class);
        Decklist decklist = new Decklist("Control", retrievedUser, "Fire fly", "Fire fly", "Fire fly", "Fire fly",
                "Fire fly","Praying Mantis","Fire fly","Fire fly","Fire fly","Fire fly","Fire fly","Fire fly",
                "Fire fly","Fire fly","Glacial Shard","Fire fly","Fire fly","Fire fly","Fire fly", "Fire fly",
                "Fire fly","Fire fly","Fire fly","Fire fly","Fire fly","Fire fly","Fire fly","Fire fly",
                "Fire fly", "Fire fly");

        deckDao.add(decklist);

        List<Decklist> decks = user.getDeckByUserId(retrievedUser);
        assertEquals(2, decks.size());

    }

}