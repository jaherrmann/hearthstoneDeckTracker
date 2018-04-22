package com.hearthstone.entity;

import com.google.gson.Gson;
import com.hearthstone.persistence.DecklistDao;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/cards")
public class GetAllCards {
    //Define what type of request this method responds to

    @GET
    //Define what is produced
    @Produces("application/json")
    public Response getMessage() {
        DecklistDao dao = new DecklistDao();
        //List<Decklist> outputStatement = dao.getAllCards();
        Gson gson = new Gson();
        List<String> outputList = new ArrayList<>();

//        for(int i = 0; i < outputStatement.size(); i++){
//            String myName = outputStatement.get(i).getName();
//            outputList.add(myName);
//        }

        String jsonArray = gson.toJson(outputList);

        return Response.status(200).entity(jsonArray).build();
    }

}
