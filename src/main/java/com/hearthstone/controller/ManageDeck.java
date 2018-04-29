package com.hearthstone.controller;

import com.hearthstone.entity.Decklist;
import com.hearthstone.persistence.DecklistDao;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/manageDeck"}
)

/**
 * This class will allow the user to view all of their decks, it will also consume a web api that will
 * retrieve stats and charateristics of specific cards.
 */
public class ManageDeck extends HttpServlet {
    Logger logger = Logger.getLogger(this.getClass());
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DecklistDao dao = new DecklistDao();
        JSONObject cardJson;
        String jsonAsString = "";
        String cardImage = "";
        ArrayList cards = new ArrayList();

        String searchTerm = request.getParameter("deckId");
        int deckId = Integer.parseInt(searchTerm);
        logger.info(deckId);

        List<Decklist> deck = dao.getDeckById(deckId);
        logger.info(deck);
        
        try {
            HttpResponse<JsonNode> restCall = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards/Fire%20Fly")
                    .header("X-Mashape-Key", "o9Hfpar1ThmshOlE9TjuxprMZBKup1aSFi3jsnSVsL68d7Vl2z")
                    .header("Accept", "application/json")
                    .asJson();
            logger.info(restCall);
            cardJson = new JSONObject(restCall.getBody());

            cardImage = parseRestCall(cardJson);

            logger.info(cardImage);
            cards.add(cardImage);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        request.setAttribute("decks", deck);
        request.setAttribute("cards", cards);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/deckDisplay.jsp");
        dispatcher.forward(request, response);

    }

    private String parseRestCall(JSONObject cardJson) {
        String foundImg = "";
        JSONArray cardArray = cardJson.getJSONArray("array");
        JSONObject cards = cardArray.getJSONObject(0);
        foundImg = cards.getString("img");
        return foundImg;
    }
}
