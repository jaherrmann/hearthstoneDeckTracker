package com.hearthstone.entity;

import com.hearthstone.persistence.DeckDao;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("/cards")
public class GetAllCards {
    //Define what type of request this method responds to

    @GET
    //Define what is produced
    @Produces("text/plain")
    public Response getMessage() {
        DeckDao dao = new DeckDao();
        //return the cards from the dao
        List<Deck> outputStatement = dao.getAllCards();

        //ObjectMapper mapper = new ObjectMapper();


        return Response.status(200).entity(outputStatement).build();
    }
}
