package com.hearthstone.entity;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/getCards")
//Defines the base URI for all resource URIs.
//The java class declares root resource and provider classes
public class DeckREST extends Application {

    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(GetAllCards.class);
        return h;
    }
}
